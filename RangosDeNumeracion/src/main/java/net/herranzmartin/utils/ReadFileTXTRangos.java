package net.herranzmartin.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTXTRangos {

	private String fileName = null;
	
	private File file = null;
	
	private List<String> numeros = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ReadFileTXTRangos rftr = new ReadFileTXTRangos();
		rftr.setFileName("/Users/jherranzm/dev/RangosNumeracion.txt");
		long numRegistros = rftr.execute(); 
		System.out.println(numRegistros);
		for(String numero : rftr.getNumeros()) {
			System.out.println(numero);
		}
		System.out.println(rftr.getNumeros().size());
 	}
	
	

	
	/**
	 * 
	 * @return
	 */
	public long execute() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				String[] chunks = sCurrentLine.split(";");
				long ini = new Long(chunks[0]);
				long fin = new Long(chunks[1]);
				for(long k = ini; k<=fin; k++) {
					numeros.add((new Long(k)).toString());
				}
			}
			
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return numeros.size();
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the numeros
	 */
	public List<String> getNumeros() {
		return numeros;
	}


	/**
	 * @param numeros the numeros to set
	 */
	public void setNumeros(List<String> numeros) {
		this.numeros = numeros;
	}




	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}

}
