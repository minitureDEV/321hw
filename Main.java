import java.io.*;
import java.util.Scanner;

public class Main {
    private static String[] key = {
            "ADD","10001011000",
            "ADDI",  "1001000100",
            "ADDIS", "1011000100",
            "ADDS",   "10101011000",
            "AND",       "10001010000",
            "ANDI",   "1001001000",
            "ANDIS",   "1111001000",
            "ANDS",     "1110101000",
            "B",         "000101",
            "BL",        "100101",
            "BR",      "11010110000",
            "CBNZ",    "10110101",
            "CBZ",     "10110100",
            "DUMP",    "11111111110",
            "EOR",      "11001010000",
            "EORI",     "1101001000",
            "FADDD",  "00011110011",
            "FADDS",  "00011110001",
            "FCMPD",   "00011110011",
            "FCMPS",  "00011110001",
            "FDIVD",   "00011110011",
            "FDIVS",   "00011110001",
            "FMULD",   "00011110011",
            "FMULS",   "00011110001",
            "FSUBD",   "00011110011",
            "FSUBS",   "00011110001",
            "HALT",     "11111111111",
            "LDUR",    "11111000010",
            "LDURB",   "00111000010",
            "LDURD",   "11111100010",
            "LDURH",   "01111000010",
            "LDURS",   "10111100010",
            "LDURSW", "10111000100",
            "LSL",       "11010011011",
            "LSR",     "11010011010",
            "MUL",     "10011011000",
            "ORR",       "10101010000",
            "ORRI",   "1011001000",
            "PRNL",   "11111111100",
            "PRNT",   "11111111101",
            "SDIV",  "10011010110",
            "SMULH",  "10011011010",
            "STUR",    "11111000000",
            "STURB",  "00111000000",
            "STURD",   "11111100000",
            "STURH",   "01111000000",
            "STURS", "10111100000",
            "STURSW",  "10111000000",
            "SUB",     "11001011000",
            "SUBI",    "1101000100",
            "SUBIS",  "1111000100",
            "SUBS",  "11101011000",
            "UDIV",   "10011010110",
            "UMULH", "10011011110"
    };
    public static void main(String[] args)
    {
//        String x ="";
//        try {
//            FileInputStream fis = new FileInputStream(new File("xxx.legv8asm.machine"));
//            int ch;
//            while ((ch = fis.read()) != -1) {
//                System.out.print((char) ch);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//       String current = "";
//       for(int i =0;i<=x.length()/32;i++)
//       {
//           String c = "";
//           for(int j=0;j<32;j++)
//           {
//               c+=x.charAt(j+i);
//           }
//           System.out.println(i+ " "+ c);
//           //current +=x.charAt(i);
//       }//00001000000000100001
      System.out.println(decompiler("1000101100000001000000000100001"));
    }
    public static String decompiler(String x)
    {

        String y;
        String out = null;
        String lastpart = "";
        for(int i=0;i<=x.length();i++)
       {
           if(out == null)
           {

           }
           else {
               break;
           }
            y = x.substring(0,i);

            for(int j =1;j<key.length;j+=2)
            {
                if(y.equals(key[j]))
                {
                    out = key[j-1];
                    lastpart = x.substring(i);
                    //System.out.println(key[j-1]);
                    break;
                }

            }
        }
        return decomp2(out,lastpart);
    }
    public static String decomp2(String x, String y)
    {
        //System.out.println(x +" "+y);
        if(x =="ADD")
        {
            rtype(x,y);
        }
        return "";
    }

    public static String rtype(String x, String y)
    {
        int rm = Integer.parseInt(y.substring(0,5),2);
        int shamt = Integer.parseInt(y.substring(5,10),2);
        int rn = Integer.parseInt(y.substring(10,15),2);
        int rd = Integer.parseInt(y.substring(15,20),2);
        System.out.println(x);
        System.out.println("rm "+ rm);
        System.out.println("shamt "+ shamt);
        System.out.println("rn "+ rn);
        System.out.println("rd "+ rd);

        return "";
    }

}
