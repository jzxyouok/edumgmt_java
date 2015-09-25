package push.ios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import push.IOSNotification;

public class IOSFilecast extends IOSNotification {
	public IOSFilecast() {
		try {
			this.setPredefinedKeyValue("type", "filecast");	
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
	// Upload file with device_tokens to Umeng
	public String uploadContents(String contents) throws Exception {
		if (!rootJson.has("appkey") || !rootJson.has("timestamp")) {
			throw new Exception("appkey, timestamp and validation_token needs to be set.");
		}
		// Construct the json string
		JSONObject uploadJson = new JSONObject();
		uploadJson.put("appkey", rootJson.getString("appkey"));
		uploadJson.put("timestamp", rootJson.getString("timestamp"));
		uploadJson.put("content", contents);
		// Construct the request
		String url = host + uploadPath;
		String postBody = uploadJson.toString();
		String sign = DigestUtils.md5Hex("POST" + url + postBody + appMasterSecret);
		url = url + "?sign=" + sign;
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		StringEntity se = new StringEntity(postBody, "UTF-8");
		post.setEntity(se);
		// Send the post request and get the response
		HttpResponse response = client.execute(post);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
		// Decode response string and get file_id from it
		JSONObject respJson = new JSONObject(result.toString());
		String ret = respJson.getString("ret");
		if (!ret.equals("SUCCESS")) {
			throw new Exception("Failed to upload file");
		}
		JSONObject data = respJson.getJSONObject("data");
		String fileId = data.getString("file_id");
		// Set file_id into rootJson using setPredefinedKeyValue
		setPredefinedKeyValue("file_id", fileId);
		return fileId;
	}
}
