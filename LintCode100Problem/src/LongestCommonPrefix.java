public class LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs){
        if(strs.length == 0){
            return "";
        }
        int shortStrLength = Integer.MAX_VALUE;
        for(String str : strs){
            if(shortStrLength > str.length()){
                shortStrLength = str.length();
            }
        }
        StringBuilder commonPrefix = new StringBuilder();
        for(int i = 0;i < shortStrLength;i++){
            StringBuilder temChar = new StringBuilder();
            boolean flag = true;
            for(String str : strs){
                String s = str.substring(i,i + 1);
                if("".equals(temChar.toString())){
                    temChar.append(s);
                }else if(s.equals(temChar.toString())){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                commonPrefix.append(temChar);
            }else{
                break;
            }
        }
        return commonPrefix.toString();
    }
}
