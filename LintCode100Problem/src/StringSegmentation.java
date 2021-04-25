public class StringSegmentation {
    public List<List<String>> StringSeg(char[] str) {
        char separator_1, separator_2;
        List<List<String>> ans = new ArrayList<>();
        List<String> key_value = new ArrayList<>();
        String tmp = "";

        separator_1 = str[0];
        separator_2 = str[1];
        for(int i = 2; i < str.length; i++) {
            if(str[i] == separator_1) {
                if(tmp != ""){
                    key_value.add(tmp);
                }
                tmp = "";
                if(key_value.size() == 2) {
                    List<String> N = new ArrayList<>();
                    N.add(key_value.get(0));
                    N.add(key_value.get(1));
                    ans.add(N);
                }
                key_value.clear();
            }
            else if(str[i] == separator_2) {
                if(tmp != ""){
                    key_value.add(tmp);
                }
                tmp = "";
            }
            else {
                tmp = tmp + str[i];
            }
        }
        if(tmp != "") {
            key_value.add(tmp);
        }
        if(key_value.size() == 2) {
            ans.add(key_value);
        }

        return ans;
    }
}
