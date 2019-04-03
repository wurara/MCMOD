package cn.wxd.utils;

public enum  FontBase {
    /**
     *   第一个参数为项目字模图像
     *   第二个参数为项目类型:{(1,汉字),(2,数字和字母)}
     *   第三个参数为项目字模点阵十六进制字符串
     */
    Util("",0,"this is the utils of FontBase")
    ,itme1("李",2,"0x00,0x00,0x0E,0x00,0x02,0x00,0x02,0x00,0x7F,0xF0,0x02,0x00,0x01,0x00,0x1F,0x80,0x62,0x30,0x12,0x40,0x0A,0x80,0x7F,0xF0,0x02,0x00,")
    ,item2("梦",2,"0x00,0x00,0x78,0x00,0x07,0x00,0x08,0xC0,0x30,0x20,0x0F,0xE0,0x04,0x00,0x10,0x40,0x55,0x50,0x38,0xE0,0x10,0x40,0x7D,0xF0,0x10,0x40,")
    ,item3("婷",2,"0x00,0x00,0x49,0x80,0x28,0x80,0x13,0xE0,0x2C,0x10,0x4F,0xF0,0x28,0x00,0x2B,0xE0,0x2A,0x20,0x7B,0xE0,0x10,0x00,0x17,0xF0,0x10,0x80,")
    ,item4("L",1,"0x00,0x00,0xFC,0x44,0x40,0x40,0x40,0x40,0x40,0x40,0xE0,0x00,0x00,")
    ,item5("o",1,"0x00,0x00,0x38,0x44,0x44,0x44,0x44,0x38,0x00,0x00,0x00,0x00,0x00,")
    ,item6("v",1,"0x00,0x00,0x10,0x28,0x28,0x44,0x44,0xC6,0x00,0x00,0x00,0x00,0x00,")
    ,item7("e",1,"0x00,0x00,0x38,0x44,0x40,0x7C,0x44,0x38,0x00,0x00,0x00,0x00,0x00,")

    ;
    private int type;
    private int height;
    private int width;
    private String word;
    private String HexCode;
    private String BinaryCode;


    FontBase(String word,int type,String HexCode){
        this.word = word;
        this.HexCode = HexCode;
        this.type = type;
        this.height = 13;
        this.width = type*8;
        this.BinaryCode = getFontBinary();
    }



    public String getHexCode() {
        return HexCode;
    }

    public String getWord() {
        return word;
    }

    public int getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getBinaryCode() {
        return BinaryCode;
    }



    public static FontBase findWord(String word){
        for (FontBase fb:FontBase.values()){
            if (fb.getWord().equals(word)){
                return fb;
            }
        }
            throw new RuntimeException("No such word or there can only be one word!!");
    }

    private String getFontBinary(){
        char[] binary ;
        String result="";
        String font = this.HexCode;
        for (int i = 0; i < this.height*type; i++) {
            String c = font.substring(2,3);

            binary = Integer.toString (Integer.parseInt (c,16), 2).toCharArray();
            result = result+formatBinary(binary);

            c = font.substring(3,4);
            binary = Integer.toString (Integer.parseInt (c,16), 2).toCharArray();
            result = result+formatBinary(binary);

            font = font.substring(font.indexOf(',')+1);
        }
        return result;
    }

    private String formatBinary(char[] binary){
        switch (String.valueOf(binary)){
            case "0":  binary = "0000".toCharArray();break;
            case "1":  binary = "0001".toCharArray(); break;
            case "10": binary = "0010".toCharArray(); break;
            case "11": binary = "0011".toCharArray(); break;
            case "100":binary = "0100".toCharArray(); break;
            case "101":binary = "0101".toCharArray(); break;
            case "110":binary = "0110".toCharArray(); break;
            case "111":binary = "0111".toCharArray(); break;
        }
        return  String.valueOf(binary);
    }

    @Override
    public String toString() {
        return "FontBase{" +
                "type=" + type +
                ", height=" + height +
                ", width=" + width +
                ", word='" + word + '\'' +
                ", HexCode='" + HexCode + '\'' +
                ", BinaryCode='" + BinaryCode + '\'' +
                '}';
    }
}
