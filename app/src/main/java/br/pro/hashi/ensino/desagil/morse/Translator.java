package br.pro.hashi.ensino.desagil.morse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Translator {
    private class Node {
        private char value;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.value = ' ';
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }
        public Node(char value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public char getValue() {
            return value;
        }
        public Node getParent() {
            return parent;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public Node getLeftChild() {
            return leftChild;
        }
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }
        public Node getRightChild() {
            return rightChild;
        }
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node root;
    private HashMap<Character, Node> map;


    public Translator() {
        root = new Node ();
        map = new HashMap<>();

        //Primeiro nivel do STACK
        this.map.put(' ',root);
        Node e = new Node('e');//DASH
        root.setLeftChild(e);
        e.setParent(root);
        this.map.put('e',e);

        Node t = new Node('t');//DOT
        root.setRightChild(t);
        t.setParent(root);
        this.map.put('t',t);

        //Segundo nivel do STACK
        Node i = new Node('i');
        e.setLeftChild(i);
        i.setParent(e);
        this.map.put('i',i);

        Node a = new Node('a');
        e.setRightChild(a);
        a.setParent(e);
        this.map.put('a',a);

        Node n = new Node('n');
        t.setLeftChild(n);
        n.setParent(t);
        this.map.put('n',n);

        Node m = new Node('m');
        t.setRightChild(m);
        m.setParent(t);
        this.map.put('m',m);

        //Terceiro nivel do STACK
        Node d = new Node('d');
        n.setLeftChild(d);
        d.setParent(n);
        this.map.put('d',d);

        Node k = new Node('k');
        n.setRightChild(k);
        k.setParent(n);
        this.map.put('k',k);

        Node g = new Node('g');
        m.setLeftChild(g);
        g.setParent(m);
        this.map.put('g',g);

        Node o = new Node('o');
        m.setRightChild(o);
        o.setParent(m);
        this.map.put('o',o);

        Node s = new Node('s');
        i.setLeftChild(s);
        s.setParent(i);
        this.map.put('s',s);

        Node u = new Node('u');
        i.setRightChild(u);
        u.setParent(i);
        this.map.put('u',u);

        Node r = new Node('r');
        a.setLeftChild(r);
        r.setParent(a);
        this.map.put('r',r);

        Node w = new Node('w');
        a.setRightChild(w);
        w.setParent(a);
        this.map.put('w',w);

        //Quarto nivel do STACK
        Node b = new Node('b');
        d.setLeftChild(b);
        b.setParent(d);
        this.map.put('b',b);

        Node x = new Node('x');
        x.setParent(d);
        d.setRightChild(x);
        this.map.put('x',x);

        Node c = new Node('c');
        k.setLeftChild(c);
        c.setParent(k);
        this.map.put('c',c);

        Node y = new Node('y');
        k.setRightChild(y);
        y.setParent(k);
        this.map.put('y',y);

        Node z = new Node('z');
        g.setLeftChild(z);
        z.setParent(g);
        this.map.put('z',z);

        Node q = new Node('q');
        g.setRightChild(q);
        q.setParent(g);
        this.map.put('q',q);


        Node NulloLeft = new Node();
        o.setLeftChild(NulloLeft);
        NulloLeft.setParent(o);
        Node NulloRight = new Node();
        o.setRightChild(NulloRight);
        NulloRight.setParent(o);

        Node h = new Node('h');
        s.setLeftChild(h);
        h.setParent(s);
        this.map.put('h',h);

        Node v = new Node('v');
        s.setRightChild(v);
        v.setParent(s);
        this.map.put('v',v);

        Node f = new Node('f');
        u.setLeftChild(f);
        f.setParent(u);
        this.map.put('f',f);

        Node RightuNull = new Node();
        u.setRightChild( RightuNull);
        RightuNull.setParent(u);

        Node l = new Node('l');
        l.setParent(r);
        r.setLeftChild(l);
        this.map.put('l',l);

        Node RightrNull = new Node();
        r.setRightChild(RightrNull);
        RightrNull.setParent(r);

        Node p = new Node('p');
        p.setParent(w);
        w.setLeftChild(p);
        this.map.put('p',p);

        Node j = new Node('j');
        j.setParent(w);
        w.setRightChild(j);
        this.map.put('j',j);

        //Quinto nivel do STACK
        Node six = new Node('6');
        b.setLeftChild(six);
        six.setParent(b);
        this.map.put('6',six);

        /*Node equals = new Node('=');//Quebra o teste
        b.setRightChild(equals);
        equals.setParent(b);
        this.map.put('=',equals); //Quebra o teste

        Node slash = new Node('/');
        x.setLeftChild(slash);
        slash.setParent(x);
        this.map.put('/',slash); //Quebra o teste*/

        Node seven = new Node('7');
        z.setLeftChild(seven);
        seven.setParent(z);
        this.map.put('7',seven);

        Node five = new Node('5');
        h.setLeftChild(five);
        five.setParent(h);
        this.map.put('5',five);

        Node four = new Node('4');
        h.setRightChild(four);
        four.setParent(h);
        this.map.put('4',four);

        Node three = new Node('3');
        v.setRightChild(three);
        three.setParent(v);
        this.map.put('3',three);

        Node two = new Node('2');
        RightuNull.setRightChild(two );
        two.setParent(RightuNull);
        this.map.put('2',two);

        Node one = new Node('1');
        j.setRightChild(one);
        one.setParent(j);
        this.map.put('1',one);

        Node eight = new Node('8');
        NulloLeft.setLeftChild(eight );
        eight.setParent(NulloLeft);
        this.map.put('8',eight);

        Node nine = new Node('9');
        NulloRight.setLeftChild(nine);
        nine.setParent(NulloRight);
        this.map.put('9',nine);

        Node zero = new Node('0');
        NulloRight.setRightChild(zero);
        zero.setParent(NulloRight);
        this.map.put('0',zero);
        //FIM DO STACK
    }

    public char morseToChar(String code) {
        Node NodeChar = root;
        if(code.length() < 6){
        for(int i = 0; i < code.length(); i++){//Percorre a arvore binaria
            if (code.charAt(i) == '-'){// Se for dash vai para direira
                NodeChar = NodeChar.getRightChild();
            }
            if (code.charAt(i) == '.'){ // Se for dot vai para esquerda
                NodeChar = NodeChar.getLeftChild();
            }
        }
        return NodeChar.getValue(); // Retorna o valor do node
        }
        else{
            return 'E';
        }

    }

    public String charToMorse(char charac) {
        Node NodeChar = map.get(charac); //Node que represenra o char
        Node NodeCharBf = map.get(charac);//Node que represenra o char anterior (Before)

        StringBuilder msg = new StringBuilder(""); //str da menssagem
        StringBuilder msg_trans = new StringBuilder();//str da menssagem traduzida

        while (NodeChar.getParent() != null){ //Percorre a arvore
            NodeChar = NodeChar.getParent(); // Node anterior
            if (NodeChar.getRightChild() == NodeCharBf){//Se o node for o da direita significa que tem um dash naquela "posição"
                msg.append("-");
                NodeCharBf = NodeCharBf.getParent();
            }
            if(NodeChar.getLeftChild() == NodeCharBf){//Se o node for o da direita significa que tem um dot naquela "posição"
                msg.append(".");
                NodeCharBf = NodeCharBf.getParent();
            }
        }
        for(int i=msg.length()-1; i>=0; i--)
            msg_trans.append(msg.charAt(i));//Junta tudo

        return msg_trans.toString();//Transforma em string e retorna
    }

    public LinkedList<String> getCodes() {

        LinkedList<String> list = new LinkedList();
        Queue<Node> queue = new LinkedList();
        queue.add(this.root);
        // root.visited = true;

        while (!queue.isEmpty()){
            Node NodeChar = queue.poll();
            if (NodeChar.getValue() != ' '){
                char letter = NodeChar.getValue();
                list.add(this.charToMorse(letter));
            }
            if (NodeChar.getLeftChild() != null) {
                queue.add(NodeChar.getLeftChild());
            }
            if (NodeChar.getRightChild() != null) {
                queue.add(NodeChar.getRightChild());
            }
        }
        return list;
    }
}