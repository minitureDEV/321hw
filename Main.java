import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
    private static int curct=0;
    private static String[] key = {
            "ADD",  "10001011000",
            "ADDI",  "1001000100",
            "ADDIS", "1011000100",
            "ADDS",   "10101011000",
            "AND",       "10001010000",
            "ANDI",   "1001001000",
            "ANDIS",   "1111001000",
            "ANDS",     "1110101000",
            "B",         "000101",
            "BL",        "100101",
            "BCon", "01010100",
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
    public static void main(String[] args) throws IOException
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

        
    //File file = new File("xxx.legv8asm.machine");	
    File file = new File("xxx.legv8asm.machine");
    ArrayList<String> compiled = new ArrayList<String>();
    ArrayList<String> decompiled = new ArrayList<String>();

    try 
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream scnr = new BufferedInputStream(fileInputStream);
        int curr;

        while((curr = scnr.read()) != -1)
        {
            String currentInstruction = "";
            int i = 0;

            do
            {
                String currentBinary = Integer.toBinaryString(curr);
                String currentEight = String.format("%8s", currentBinary).replace(' ', '0');
                currentInstruction += currentEight;
                i++;

            }while(i < 4 && ((curr = scnr.read()) != -1));

            compiled.add(currentInstruction);
            

            /**
            String instruction = "";
            String binary = Integer.toBinaryString(curr);
            String leadZero = String.format("%8s", binary).replace(' ', '0');
            curr = scnr.read();
            String binary2 = Integer.toBinaryString(curr);
            String leadZero2 = String.format("%8s", binary2).replace(' ', '0');
            curr = scnr.read();
            String binary3 = Integer.toBinaryString(curr);
            String leadZero3 = String.format("%8s", binary3).replace(' ', '0');
            curr = scnr.read();
            String binary4 = Integer.toBinaryString(curr);
            String leadZero4 = String.format("%8s", binary4).replace(' ', '0');
            //instruction = leadZero + leadZero1 + leadZero2 + leadZero3 + leadZero4;
            instruction += leadZero;
            instruction += leadZero2;
            instruction += leadZero3;
            instruction += leadZero4;
            compiled.add(instruction);
            **/
        
        }
    
        scnr.close();
    } 

    catch (FileNotFoundException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    //creates converted instructions into arraylist
    for(int i = 0; i < compiled.size(); i++)
    {
        //System.out.println(compiled.get(i));
        decompiled.add(decompiler(compiled.get(i)));
        curct++;
    }
    
    //outputs arraylist of compiled constructions to a new file
    File outputFileName = new File("test.txt");
    PrintWriter output = new PrintWriter(outputFileName);
    
    for(int i = 0; i < decompiled.size(); i++)
    {
        String line = decompiled.get(i).toString();
        output.println(line);
    }
      
    output.close();	
    
    //System.out.println(decompiler("1000101100000001000000000100001"));
    //System.out.println(decompiler(data));
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
        String ret="idek";
        //System.out.println(x +" "+y);
        if(x.equals("ADD")||x.equals("ADDS")||x.equals("AND")||x.equals("ANDS")||x.equals("BR")
                ||x.equals("EOR")||x.equals("LSL")||x.equals("LSR")||x.equals("ORR")
                ||x.equals("SUB")||x.equals("SUBS")||x.equals("FADDS")||x.equals("FADDD")
                ||x.equals("FCMPS")||x.equals("FCMPD")||x.equals("FDIVS")||x.equals("FDIVD")
                ||x.equals("FMULS")||x.equals("FMULD")||x.equals("FSUBS")||x.equals("FSUBD")
                ||x.equals("LDURS")||x.equals("LDURD")||x.equals("MUL")||x.equals("SDIV")
                ||x.equals("SMULH")||x.equals("STURS")||x.equals("STURD")||x.equals("UDIV")||x.equals("UMULH")||x.equals("LSL")||x.equals("LSR")
        )
        {
            ret =rtype(x,y);
        }
        else if(x.equals("ADDI")||x.equals("ADDIS")||x.equals("ANDI")||x.equals("ANDIS")||x.equals("EORI")||x.equals("ORRI")
                ||x.equals("SUBI")||x.equals("SUBIS"))
        {
            ret = itype(x,y);
        }
        else if(x.equals("STUR")||x.equals("LDUR"))
        {
            ret = dtype(x,y);
        }
        else if(x.equals("BCon"))
        {
            ret = branchcondtype(x,y);
        }
        else if(x.equals("B"))
        {
            ret = b(x,y);
        }
        return ret;
    }

    public static String rtype(String x, String y)
    {
        String ret = "idek";
        int rm = Integer.parseInt(y.substring(0,5),2);
        int shamt = Integer.parseInt(y.substring(5,11),2);
        int rn = Integer.parseInt(y.substring(11,16),2);
        int rd = Integer.parseInt(y.substring(16,21),2);
        if(x.equals("ADD")||x.equals("ADDS")||x.equals("AND")||x.equals("ANDS")||x.equals("FADDD")||x.equals("FADDDS")
                ||x.equals("FCMPD")||x.equals("FCMPS")||x.equals("FDIVD")||x.equals("FDIVS")||x.equals("FMULD")||x.equals("FMULS")
                ||x.equals("FSUBD")||x.equals("FSUBS")||x.equals("SDIV")||x.equals("MUL")||x.equals("SMULH")||x.equals("SUB")
                ||x.equals("SUBS")||x.equals("UDIV")||x.equals("UMULH")
        )
        {
            ret = x + " X"+rd+","+" X"+rn+", X"+ rm;

        }
        else if(x.equals("LSL")||x.equals("LSR"))
        {
            ret = x + " X"+rd+","+" X"+rn+", #"+ shamt;
        }
        System.out.println(ret);
        return ret;
    }
    public static String itype(String x, String y)
    {
        String ret = "idek";
        int ALU = Integer.parseInt(y.substring(0,12),2);
        int rn = Integer.parseInt(y.substring(12,17),2);
        int rd = Integer.parseInt(y.substring(17,22),2);
        if(x.equals("ADDI")||x.equals("ADDIS")||x.equals("ANDI")||x.equals("ANDIS")||x.equals("SUBI")||x.equals("SUBIS"))
        {
            ret = x + " X"+rd+","+" X"+rn+", #"+ ALU;

        }
        System.out.println(ret);
        return ret;
    }
    public static String dtype(String x, String y)
    {
        String ret = "idek";
        int DTadd = Integer.parseInt(y.substring(0,9),2);
        int op = Integer.parseInt(y.substring(9,11),2);
        int rn = Integer.parseInt(y.substring(11,16),2);
        int rt = Integer.parseInt(y.substring(16,21),2);
        if(x.equals("STUR")||x.equals("LDUR"))
        {
            ret = x + " X"+rt+","+" [X"+rn+", #"+ DTadd+"]";
            System.out.println(ret);
        }
        return ret;
    }
    public static String branchcondtype(String x, String y)
    {
        String ret = "idek";
        int condbr = (byte)Integer.parseInt(y.substring(0,19),2);
        int rt = Integer.parseInt(y.substring(19,24),2);
        String cd = "";

        switch (rt) {
            case 0:  cd = "EQ";
                break;
            case 1:  cd = "NE";
                break;
            case 2:  cd = "HS";
                break;
            case 3:  cd = "LO";
                break;
            case 4:  cd = "MI";
                break;
            case 5:  cd = "PL";
                break;
            case 6:  cd = "VS";
                break;
            case 7:  cd = "VC";
                break;
            case 8:  cd = "HI";
                break;
            case 9: cd = "LS";
                break;
            case 10: cd = "GE";
                break;
            case 11: cd = "LT";
                break;
            case 12: cd = "GT";
                break;

            default: cd = "LE";
                break;

        }

        condbr = condbr+=curct;

        //ret ="B."+cd+" branch"+condbr+ "current branch: "+curct;
        ret ="B."+cd+" branch"+condbr;
        System.out.println(ret);

        return ret;
    }
    public static String b(String x, String y)
    {
        String ret = "idek";
        int condbr = (byte)Integer.parseInt(y.substring(0,26),2);

        condbr = condbr+=curct;

        //ret = "B " + " branch"+condbr + "current branch: "+curct;
        ret = "B " + " branch"+condbr;
        System.out.println(ret);

        return ret;
    }
}
