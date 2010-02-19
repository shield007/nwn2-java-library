/*
 *  Copyright (C) 2008  John-Paul.Stanford <dev@stanwood.org.uk>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.stanwood.nwn2.tlk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class is used to parse and retrieve the contents of a Neverwinter Nights 2 string file (TLK)
 */
public class TLKParser {

	private final static int HEADER_SIZE = 20;
	private final static int DATA_ELEMENT_SIZE = 4 + 16 + 4 + 4 + 4 + 4 + 4;
	
	private RandomAccessFile is = null;
	private String fileType;
	private String fileVersion;
	private int langId;
	private int stringCount;
	private int stringEntriesOffset;
	
	/**
	 * Open the parser file and read the header
	 * @param file The file to parse
	 * @throws IOException Thrown if their is a problem reading the file
	 */
	public void open(File file) throws IOException {		
		is = new RandomAccessFile(file,"r");			
		readHeader();		
	}
	
	/**
	 * Close the TLK file
	 * @throws IOException If their is a problem closing the file
	 */
	public void close() throws IOException {
		is.close();
		is = null;
	}

	private void readHeader() throws IOException {		
		fileType = readString(4);
		fileVersion = readString(4);
		langId = is.readInt();
		stringCount = readInt();
		stringEntriesOffset = readInt(); 
	}
	
	private int readInt() throws IOException {
		int v = is.readInt();
		return  (v >>> 24) | (v << 24) | 
	       ((v << 8) & 0x00FF0000) | ((v >> 8) & 0x0000FF00);		
	}
	
	private String readString(int size) throws IOException {
		StringBuilder result = new StringBuilder();
		byte data[] = new byte[size];
		is.read(data);
        for (byte element : data) {
            result.append((char) (element & 0xFF));
        }					
		return result.toString();
	}
	
	/**
	 * Read a string entry from the opened TLK file
	 * @param id The ID of the string to read. The ID must be > 0
	 * @return The string entry
	 * @throws IOException Thrown if their is a problem reading the entry
	 */
	public TLKEntry readEntry(int id) throws IOException {
		if (id < 0) {
			throw new IllegalArgumentException("ID with value "+id+" cannot be less than 0");
		}
		
		is.seek(HEADER_SIZE+(id * DATA_ELEMENT_SIZE));
		
		int flags = readInt();
		String soundResRef = readString(16);
		int volumnVariance = readInt();
		int pitchVariance = readInt();
		int offset = readInt();
		int size = readInt();
		float soundLength = readFloat();
		
		is.seek(stringEntriesOffset + offset);
		
		String text = readString(size);
		text = (flags & 0x1) > 0 ? text : "";
		soundResRef = (flags & 0x2) > 0 ? soundResRef : "";
		soundLength = (flags & 0x4) > 0 ? soundLength : 0F;
						
		TLKEntry entry = new TLKEntry(); 		
		entry.setPitchVariance(pitchVariance);
		entry.setSoundResRef(soundResRef);
		entry.setSoundLength(soundLength);
		entry.setText(text);
		entry.setVolumnVariance(volumnVariance);		
		return entry;
	}

	private static float arr2float (byte[] arr, int start) {
		int i = 0;
		int len = 4;
		int cnt = 0;
		byte[] tmp = new byte[len];
		for (i = start; i < (start + len); i++) {
			tmp[cnt] = arr[i];
			cnt++;
		}
		int accum = 0;
		i = 0;
		for ( int shiftBy = 0; shiftBy < 32; shiftBy += 8 ) {
			accum |= ( (long)( tmp[i] & 0xff ) ) << shiftBy;
			i++;
		}
		return Float.intBitsToFloat(accum);
	}
	
	private float readFloat() throws IOException {		
		byte data[] = new byte[4];
		is.read(data);
		return arr2float(data,0);
	}

	/**
	 * Returns the file type
	 * @return The file type
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * Returns the file version
	 * @return The file version
	 */
	public String getFileVersion() {
		return fileVersion;
	}

	/**
	 * Gets the language of the the file
	 * @return the language of the the file
	 */
	public int getLangId() {
		return langId;
	}

	/**
	 * Gets the number of string entries in the file
	 * @return The number of string entries in the file
	 */
	public int getStringCount() {
		return stringCount;
	}	
}