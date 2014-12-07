package com.training.first;

public class ReadNGivenRead4 {

	private int read4(char[] buf) {
		return 4;
	}

	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4) eof = true;
			int bytes = Math.min(n - readBytes, sz);
			System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */,
					readBytes /* destPos */, bytes /* length */);
			readBytes += bytes;
		}
		return readBytes;
	}
	
	public int read2(char[] buf, int n){
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		while(!eof && readBytes<n){
			int sz = read4(buffer);
			if(sz<4) eof=true;
			int bytes = Math.min(sz, n-readBytes);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		return readBytes;
	}
	
	private char[] buffer = new char[4];
	int offset=0, bufsize=0;
	public int read3(char[] buf, int n){
		int readBytes = 0;
		boolean eof = false;
		while(!eof && readBytes<n){
			if(bufsize==0){
				bufsize = read4(buffer);
				eof = bufsize<4;
			}
			int bytes = Math.min(n-readBytes, bufsize);
			System.arraycopy(buffer, offset, buf, readBytes, bytes);;
			offset=(offset + bytes)%4;
			bufsize -= bytes;
			readBytes += bytes;
		}
		return readBytes;
	}
	
	public static void main(String[] args){
		int[] xyz = {1,3,5,2,4,6};
		int[] abc = new int[6];
		System.out.println(xyz[0]);
		System.out.println(xyz[5]);
		System.arraycopy(xyz, 0, abc, 0, 6);
		System.out.println(abc[0]);
		System.out.println(abc[5]);
	}
}
