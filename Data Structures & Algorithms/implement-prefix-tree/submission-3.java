class PrefixTree {

    List<String> trieContents;
    public PrefixTree() {
        trieContents = new ArrayList();
         
    }

    public void insert(String word) {
           trieContents.add(word);
    }

    public boolean search(String word) {
       for(String str : trieContents){
        if(str.equals(word))
        return true;
       }
       return false;
    }

    public boolean startsWith(String prefix) {
        int pLen = prefix.length();
        for(String str : trieContents){
        if(str.length()>=pLen && str.substring(0,pLen).equals(prefix))
        return true;
       }
       return false;
    }
}
