package com.centroxy.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class ReadCsv {
	public static void main(String[] args) throws Exception {
		String line ;  
		String splitBy = ",";  
		String[] columnsInput=new String[10];
		String[] columnsOutput=new String[28];
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		int sNo=1;
		
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter path of your old CSV File : ");
		String inputFilePath=sc.next();
		
		System.out.print("Enter path where you want to store the new CSV file : ");
		String outputFilePath=sc.next();
		
		FileWriter fileWriter = new FileWriter(outputFilePath);
		BufferedWriter br1=new BufferedWriter(fileWriter);

		try   
		{  
			
			//parsing a CSV file into BufferedReader class constructor  
			BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
			CSVWriter csvWrite = new CSVWriter(fileWriter);
			 String[] entries = {"Transaction Type","Beneficiary Code","Beneficiary Account Number","Instrument Amount","Beneficiary Name","Drawee Location","Print Location","Bene Address 1","Bene Address 2","Bene Address 3","Bene Address 4","Bene Address 5","Instruction Reference Number","Customer Reference Number","Payment details 1","Payment details 2","Payment details 3","Payment details 4","Payment details 5","Payment details 6","Payment details 7","Cheque Number","Chq / Trn Date","MICR Number","IFC Code","Bene Bank Name","Bene Bank Branch Name","Beneficiary email id"};
			 csvWrite.writeNext(entries);
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				columnsInput = line.split(splitBy);    // use comma as separator  
				//System.out.println(columnsInput[4]);
				if(columnsInput[4].contains("HDFC")) {
					columnsOutput[0]="I";
				}else {
					columnsOutput[0]="N";
				}

				if(sNo<10) {
					columnsOutput[1]="A000"+sNo;
					sNo++;
				}else if(sNo<100) {
					columnsOutput[1]="A00"+sNo;
					sNo++;
				}else if(sNo<1000) {
					columnsOutput[1]="A0"+sNo;
					sNo++;
				}else {
					columnsOutput[1]="A"+sNo;
					sNo++;
				}

				columnsOutput[2]=columnsInput[3];
				columnsOutput[3]=columnsInput[2];
				columnsOutput[4]=columnsInput[5];
				columnsOutput[5]=" ";
				columnsOutput[6]=" ";
				columnsOutput[7]=" ";
				columnsOutput[8]=" ";
				columnsOutput[9]=" ";
				columnsOutput[10]=" ";
				columnsOutput[11]=" ";
				columnsOutput[12]=columnsInput[3];
				columnsOutput[13]="sal "+columnsInput[5];
				columnsOutput[14]=" ";
				columnsOutput[15]=" ";
				columnsOutput[16]=" ";
				columnsOutput[17]=" ";
				columnsOutput[18]=" ";
				columnsOutput[19]=" ";
				columnsOutput[20]=" ";
				columnsOutput[21]=" ";
				columnsOutput[22]=formatter.format(date);
				columnsOutput[23]=" ";
				columnsOutput[24]=columnsInput[4];
				columnsOutput[25]=" ";
				columnsOutput[26]=" ";
				

				

				columnsOutput[27]="jajati@centroxy.com";

				
				
				int count=0;
				while(count<1) {
					StringBuilder sb = new StringBuilder();
					
					for (int j=0;j<columnsOutput.length;j++) {
						String element=columnsOutput[j];
						
						//System.out.println(element);
						sb.append(element);
						if(j==columnsOutput.length-1) {
							break;
						}
						sb.append(",");
					}
					sb.append("\n");
					
					br1.write(sb.toString());


					count++;
				}

			}

			System.out.println();

			br.close();
			br1.close();
			System.out.println("File generated... Thank You");

		}//TRY
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Sorry!! File Generation Failed....");
		}

	} //MAIN()
}//CLASS
