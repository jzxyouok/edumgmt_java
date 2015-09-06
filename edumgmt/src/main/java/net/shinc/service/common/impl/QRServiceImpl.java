package net.shinc.service.common.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.shinc.service.common.QRService;
import net.shinc.utils.MatrixToImageWriter;
import net.shinc.utils.UUIDUtils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @ClassName QRServiceImpl 
 * @Description 二维码生成实现类
 * @author guoshijie 
 * @date 2015年9月6日 下午5:02:15
 */
@Service
public class QRServiceImpl implements QRService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String generateQrCode(String filePath, String phpPath, Integer videoBaseId) {
		try {
			 MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     String content = phpPath + videoBaseId.toString();
		     logger.info("content"+content);
		     
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
		     
		     String qrName = "qr_" + UUIDUtils.getUuid() + ".png";
		     File file = new File(filePath, qrName);
		     MatrixToImageWriter.writeToFile(bitMatrix, "png", file);
		     String abName = file.getAbsolutePath();
		     logger.info(abName);
		     return abName;
		 } catch (Exception e) {
			 logger.error(ExceptionUtils.getStackTrace(e));
		 }
		return null;
	}

}
