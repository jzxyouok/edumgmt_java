package net.shinc.orm.mybatis.bean.edu;

import java.text.MessageFormat;

public class MyRet {

	public long fsize;
	public String key;
	public String hash;
	public int width;
	public int height;
	
	@Override
	public String toString() {
		return MessageFormat.format("size:{0}\tkey:{1}\thash:{2}\twidth:{3}\theight:{4}", this.fsize,this.key,this.hash,this.width,this.height);
	}
}
