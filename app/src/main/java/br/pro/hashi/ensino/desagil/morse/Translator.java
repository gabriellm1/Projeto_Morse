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
        map = new HashMap<Character, Node>();

        //Primeiro nivel do STACK
        this.map.put(' ',root);
        Node e = new Node('e');//DASH
        root.setLeftChild(e);
        e.setParent(root);
        Node t = new Node('t');//DOT
        root.setRightChild(t);
        t.setParent(root);

        //Segundo nivel do STACK
        Node i = new Node('i');
        e.setLeftChild(i);
        i.setParent(e);
        Node a = new Node('a');
        e.setRightChild(a);
        a.setParent(e);
        Node n = new Node('n');
        t.setLeftChild(n);
        n.setParent(t);
        Node m = new Node('m');
        t.setRightChild(m);
        m.setParent(t);

        //Terceiro nivel do STACK
        Node d = new Node('d');
        n.setLeftChild(d);
        d.setParent(n);
        Node k = new Node('k');
        n.setRightChild(k);
        k.setParent(n);

        Node g = new Node('g');
        m.setLeftChild(g);
        g.setParent(m);

        Node o = new Node('o');
        m.setRightChild(o);
        o.setParent(m);

        Node s = new Node('s');
        i.setLeftChild(s);
        s.setParent(i);
        Node u = new Node('u');
        i.setRightChild(u);
        u.setParent(i);

        Node r = new Node('r');
        a.setLeftChild(r);
        r.setParent(a);
        Node w = new Node('w');
        a.setRightChild(w);
        w.setParent(a);

        //Quarto nivel do STACK
        Node b = new Node('b');
        d.setLeftChild( b);
        b.setParent(d);
        Node x = new Node('x');
        d.setRightChild( x);
        x.setParent(d);

        Node c = new Node('c');
        k.setLeftChild(c);
        c.setParent(k);
        Node y = new Node('y');
        k.setRightChild(y);
        y.setParent(k);

        Node z = new Node('z');
        g.setLeftChild(z);
        z.setParent(g);
        Node q = new Node('q');
        g.setRightChild(q);
        q.setParent(g);

        Node NulloLeft = new Node();
        o.setLeftChild(NulloLeft);
        NulloLeft.setParent(o);
        Node NulloRight = new Node();
        o.setRightChild(NulloRight);
        NulloRight.setParent(o);

        Node h = new Node('h');
        s.setLeftChild(h);
        h.setParent(s);
        Node v = new Node('v');
        s.setRightChild(v);
        v.setParent(s);

        Node f = new Node('f');
        u.setLeftChild(f);
        f.setParent(u);
        Node RightuNull = new Node();
        u.setRightChild( RightuNull);
        RightuNull.setParent(u);

        Node l = new Node('l');
        l.setParent(r);
        r.setLeftChild(l);
        Node RightrNull = new Node();
        r.setRightChild(RightrNull);
        RightrNull.setParent(r);

        Node p = new Node('p');
        p.setParent(w);
        w.setLeftChild(p);
        Node j = new Node('j');
        j.setParent(w);
        w.setRightChild(j);

        //Quinto nivel do STACK
        Node six = new Node('6');
        b.setLeftChild(six);
        six.setParent(b);
       // Node equals = new Node('=');Quebra o tete
        //b.setRightChild(equals);
       // equals.setParent(b);

        //Node slash = new Node('/');
        //x.setLeftChild(slash);
        //slash.setParent(x);

        Node seven = new Node('7');
        z.setLeftChild(seven);
        seven.setParent(z);

        Node five = new Node('5');
        h.setLeftChild(five);
        five.setParent(h);
        Node four = new Node('4');
        h.setRightChild(four);
        four.setParent(h);

        Node three = new Node('3');
        v.setRightChild(three);
        three.setParent(v);

        Node two = new Node('2');
        RightuNull.setRightChild(two );
        two.setParent(RightuNull);

        Node one = new Node('1');
        j.setRightChild(one);
        one.setParent(j);

        Node eight = new Node('8');
        NulloLeft.setLeftChild(eight );
        eight.setParent(NulloLeft);

        Node nine = new Node('9');
        NulloRight.setLeftChild(nine);
        nine.setParent(NulloRight);

        Node zero = new Node('0');
        NulloRight.setRightChild(zero);
        zero.setParent(NulloRight);

        //FIM DO STACK

        //Atribui uma str para cada node no Hashmap
        this.map.put('0',zero);
        this.map.put('1',one);
        this.map.put('2',two);
        this.map.put('3',three);
        this.map.put('4',four);
        this.map.put('5',five);
        this.map.put('6',six);
        this.map.put('7',seven);
        this.map.put('8',eight);
        this.map.put('9',nine);
       // this.map.put('=',equals); Quebra o tete
       // this.map.put('/',slash); uebra o tete
        this.map.put('a',a);
        this.map.put('b',b);
        this.map.put('c',c);
        this.map.put('d',d);
        this.map.put('e',e);
        this.map.put('f',f);
        this.map.put('g',g);
        this.map.put('h',h);
        this.map.put('i',i);
        this.map.put('j',j);
        this.map.put('k',k);
        this.map.put('l',l);
        this.map.put('m',m);
        this.map.put('n',n);
        this.map.put('o',o);
        this.map.put('p',p);
        this.map.put('q',q);
        this.map.put('r',r);
        this.map.put('s',s);
        this.map.put('t',t);
        this.map.put('u',u);
        this.map.put('v',v);
        this.map.put('w',w);
        this.map.put('x',x);
        this.map.put('y',y);
        this.map.put('z',z);
    }

    public char morseToChar(String code) {
        Node NodeChar = root;
        for(int i = 0; i < code.length(); i++){//Percorre a arvore binaria
            if (code.charAt(i) == '-'){// Se for dash vai para direira
                NodeChar = NodeChar.getRightChild();
            }
            if (code.charAt(i) == '.'){ // Se for dash vai para esquerda
                NodeChar = NodeChar.getLeftChild();
            }

        }
        return NodeChar.getValue(); // Retorna o valor do node
    }

    public String charToMorse(char charac) {
        Node NodeChar = map.get(charac); //Node que represenra o char
        Node NodeCharBf = map.get(charac);//Node que represenra o char anterior (Before)

        StringBuilder msg = new StringBuilder(""); //Icia a str da menssagem
        StringBuilder msg_trans = new StringBuilder();//Icia a str da menssagem traduzida

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

        LinkedList<String> morse_list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            Node NodeChar = queue.poll();

            if (NodeChar.getValue() != ' '){
                morse_list.add(this.charToMorse(NodeChar.getValue()));
            }

            if (NodeChar.getLeftChild() != null) {
                queue.add(NodeChar.getLeftChild());
            }

            if (NodeChar.getRightChild() != null) {
                queue.add(NodeChar.getRightChild());
            }
        }

        return morse_list;
    }
}