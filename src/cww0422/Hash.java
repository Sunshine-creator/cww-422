package cww0422;
public class Hash {
    static class Node {
      public   int val;
      public   int key;
      public Node next;//下一个节点

        public Node(int key,int val) {
            this.key = key;
            this.val =val;
        }
    }
    private Node[] array = new Node[101]; //用数组表示hash
    private int size=0; //有效元素
    private int hashFuc(int key){  //这里采用取余，表示下标
        return key % array.length;
    }
    public void put(int key,int val){  //hash插入,假如存在，舅父干掉，将key映射成下组的下标
        int index = hashFuc(key);
        Node list = array[index];  //找到对应的链表
        for(Node cur = list;cur!=null;cur=cur.next){   //遍历整个链表
            if(cur.key==key){   //这里表示里面有要插入的元素
                cur.val=val;  //修改元素
                return;
            }
        }
        Node newNode = new Node( key, val);//新增加一个结点，在这里进行头插
         newNode.next=list;
         array[index] = newNode;//
         size++;//更新有效元素的个数
          if(size /array.length>FACTOR){
              resize();
          }
    }

    private void resize() {    //进行扩容
        Node[] newArr = new Node[array.length*3];//扩容，将原来的数据进行备份
        for(int i=0;i<array.length;i++){
            for(Node cur=array[i];cur!=null;cur=cur.next){
                int index=cur.key%newArr.length;
                Node newNode =new Node(cur.key,cur.val);
                newNode.next=newArr[index];
                newArr[index]=newNode;
            }
        }
        array=newArr;//让新的数组指向新的数组
    }

    public  Integer get(int key){  //根据key进行查找，若找到返回val；找不到返回null,哈希表的查
       int index = hashFuc(key);
       Node list = array[index];
       for(Node cur =list;cur!=null;cur=cur.next){
           if(cur.key==key){
               return cur.val;
           }
       }
       return null;
    }
    private  static final double FACTOR=0.75;//设置负载因子

}
