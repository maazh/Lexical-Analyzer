package lexer;

import java.io.*;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;
import java.io.StringReader;

public class main {
	
	
	public static void lexer(String input) {
		StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(input));
		streamTokenizer.commentChar('#');
		try {
			while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
				if (streamTokenizer.ttype == streamTokenizer.TT_NUMBER) {
					System.out.println(streamTokenizer.toString() + "  number");
				}
				else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
					if (streamTokenizer.toString().contains("int") || streamTokenizer.toString().contains("char")
							|| streamTokenizer.toString().contains("double")
							|| streamTokenizer.toString().contains("void")
							|| streamTokenizer.toString().contains("main")

					) {
						System.out.println(streamTokenizer.toString() + "  ,keyword");
					}
					else {

						System.out.println(streamTokenizer.toString() + "  ,Identifier");

					}

				} else if (streamTokenizer.ttype == 59) {
					System.out.println(streamTokenizer.toString() + "  ,Semicolon");
				} else if (streamTokenizer.ttype == 40) {
					System.out.println(streamTokenizer.toString() + "  ,Left Paranthesis");
				} else if (streamTokenizer.ttype == 41) {
					System.out.println(streamTokenizer.toString() + "  ,Right Paranthesis");
				} else if (streamTokenizer.ttype == -3) {
					System.out.println(streamTokenizer.toString() + "  ,semicolon");
				} else if (streamTokenizer.ttype == 125) {
					System.out.println(streamTokenizer.toString() + "  ,Open Brace");
				} else if (streamTokenizer.ttype == 123) {
					System.out.println(streamTokenizer.toString() + "  ,Close Braces");
				} else {

					if (streamTokenizer.toString().contains("*") || streamTokenizer.toString().contains("+")
							|| streamTokenizer.toString().contains("/")

					) {
						System.out.println(streamTokenizer.toString() + " ,Arithmetic operator");
					} else if (streamTokenizer.toString().contains("=")) {
						System.out.println(streamTokenizer.toString() + " ,Assignment operator");

					}

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// The name of the file to open.
        String fileName = "C:\\Users\\maazh\\eclipse-workspace\\lexer\\src\\lexer\\temp.txt";

        // This will reference one line at a time
        String line = null;
        String valuess = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
              //  System.out.println(line);
                valuess = valuess +  "\r\n" + line;
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'" + ex);                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
		//System.out.println("---" + valuess);
		
	//	String inputval = "#include<stdio.h>\r\n" + "\r\n"
			//	+ "void main()\r\n" + "\r\n" + "{\r\n" + "\r\n" + "int a; double b; char c;\r\n" + "A=B+C*24"
		//		+ ";printf(\"%d %b %c\",a,b,c);\r\n" + "\r\n" + "}\r\n" + "";
		
		lexer(valuess);

	}

}
