class Pair{
    int views;
    String id;
    int sum;
    Pair(int views,String id,int sum){
        this.views=views;
        this.id=id;
        this.sum=sum;
    }
}
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,Pair> hm=new HashMap<>();             
        for(int i=0;i<creators.length;i++){
            if(!hm.containsKey(creators[i])){
                hm.put(creators[i],new Pair(views[i],ids[i],views[i]));
            }
            else{
                Pair p=hm.get(creators[i]);
                p.sum+=views[i];
                if(views[i]>p.views){
                    p.views=views[i];
                    p.id=ids[i];
                }
                else if(p.views==views[i]){
                    if(p.id.compareTo(ids[i])>0)
                        p.id=ids[i];
                }
            }
        }
        int max=-1;
        for(String str:hm.keySet()){
            max=Math.max(max,hm.get(str).sum);
        }
        for(String str:hm.keySet()){
            if(hm.get(str).sum==max){
                List<String> li=new ArrayList<>();
                li.add(str);
                li.add(hm.get(str).id);
                res.add(li);
            }
        }
        return res;        
    }
}