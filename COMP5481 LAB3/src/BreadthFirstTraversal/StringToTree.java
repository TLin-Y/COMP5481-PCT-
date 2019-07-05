package BreadthFirstTraversal;

/* Class containing left and right child of current  
node and key value*/
public class StringToTree {
    private int i = 1; // make i global
    
    public Nodet str2tree(String s) {
        if (s.equals(""))    return null;
        return dfs(s);
    }
    private Nodet dfs(String s){
        Nodet root = null;
        if (s.charAt(i) != '(') {
            root = new Nodet(getInputVal(s));
        }
        
        Nodet leftNode = null, rightNode = null;
        if (i < s.length() && s.charAt(i) == '(') { // for the possible leftNode, if '(' met.
            i++;
            leftNode = dfs(s);
        }
        if (i < s.length() && s.charAt(i) == '(') { // for the possible rightNode, if '(' met.
            i++;
            rightNode = dfs(s);
        }
        // if not '(' it must be ')' or i==s.length()
        // so we return the current stack
        root.left = leftNode;
        root.right = rightNode;
        i++;
        //System.out.print(root.data);
        return root;
    }
    
    private String getInputVal(String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                    break;
            sb.append(s.charAt(i));
            i++;
        }
        String inputv = sb.toString();
        //System.out.println("inputv="+inputv);
        return inputv;
    }
}

