package fileVisitors.util;

import fileVisitors.util.MyLogger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileProcessor{
    private BufferedReader bfRead;

   /**
    * Constructor for file processor. Tries to open
    * file passed into class, and catches Exception 
    * generated if file is not found
    *
    * @return - no return from constructor
    */
    public FileProcessor(String s)
    {
        MyLogger.writeMessage("FileProcessors constructor called", 4);
	try
	{
            bfRead = new BufferedReader(new FileReader(s));
	}
	catch(FileNotFoundException e)
	{
	    e.printStackTrace();
	}
    }

   /**
    * Reads bfRead line by line. Catches IOException if
    * generated by the readLine call
    *
    * @return String - line read from file
    */
    public String readLine()
    {
	String line = "";
	try
	{
	    line = bfRead.readLine();
	}
	catch(IOException e)
	{
	    e.printStackTrace();
	}
	return line;
    }

   /**
    * Closes BufferedReader
    *
    * @return void - no return type
    */
    public void close()
    {
        try
	{
	    bfRead.close();
	}
	catch(IOException e)
	{
	    e.printStackTrace();
	}
    }
}