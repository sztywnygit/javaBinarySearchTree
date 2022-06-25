public class BinaryTree {

private Node head;


public BinaryTree(){
    head = null;
}

public void addElement(int element){

    if(head==null){
        head = new Node(element,null,null);
        return;
    }

    Node temp = head;

    while(true){
        if(element>=temp.getValue()){
            if(temp.getRight()==null){
                temp.setRight(new Node(element,null,null));
                return;
            }
            temp = temp.getRight();
        } else {
            if(temp.getLeft()==null){
                temp.setLeft(new Node(element,null,null));
                return;
            }
            temp = temp.getLeft();
        }
    }
}

public void printPathToElement(int element){
    if(head!=null){
        Node temp = head;
        String path="";
        while(true){
            if(temp.getValue()==element) {
                path+= " -> "+ element;
                System.out.println(path);
                return;
            } else {
                if(element>=temp.getValue()){
                    if(temp.getRight()!=null) {
                        path+=" -> " + temp.getValue();
                        temp = temp.getRight();
                    } else {
                        System.out.println("element not present!");
                        return;
                    }
                } else {
                    if(temp.getLeft()!=null) {
                        path+=" -> " + temp.getValue();
                        temp = temp.getLeft();
                    } else {
                        System.out.println("element not present!");
                        return;
                    }
                }
            }
        }
    } else System.out.println("The binary tree is empty!");
}

public boolean isPresent(int element) {
    if (head != null) {
        Node temp = head;
        while (true) {
            if (temp.getValue() == element) return true;
            if (element > temp.getValue()) {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                } else return false;
            } else {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                } else return false;
            }
        }
    } else return false;
}

public boolean deleteElement(int element){
    if(head!=null) {
        Node temp = head;
        Node parent = null;
        while (true) {
            if(temp.getValue()==element){
                int childCount = 0;

                if(temp.getRight()!=null && temp.getLeft()!=null) childCount = 2;
                else if(temp.getRight()!=null && temp.getLeft()==null) childCount = 1;
                else if(temp.getRight()==null && temp.getLeft()!=null) childCount = 1;

                switch (childCount){
                    case 0:
                        if(parent == null){
                            head = null;
                            return true;
                        }
                        if(element>parent.getValue()){
                            parent.setRight(null);
                        } else parent.setLeft(null);
                        break;
                    case 1:
                        if(parent==null){
                            if(temp.getRight()!=null) {
                                   head = temp.getRight();
                            } else {
                                   head = temp.getLeft();
                            }
                            return true;
                        }
                        if(temp.getRight()!=null) {
                            if(temp.getRight().getValue()>parent.getValue()){
                                parent.setRight(temp.getRight());
                            } else parent.setLeft(temp.getRight());
                        } else {
                            if(temp.getLeft().getValue()<parent.getValue()){
                                parent.setLeft(temp.getLeft());
                            } else parent.setRight(temp.getLeft());
                        }
                        break;
                    case 2:
                        if(parent==null){
                            head = temp.getLeft();
                            Node temp2 = head;
                            while(true) {
                                if (temp.getRight().getValue() >= temp2.getValue()) {
                                    if (temp2.getRight() == null) {
                                        temp2.setRight(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getRight();
                                } else {
                                    if (temp2.getLeft() == null) {
                                        temp2.setLeft(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getLeft();
                                }
                            }
                            return true;
                        }
                        if(element>=parent.getValue()) {
                            parent.setRight(temp.getLeft());
                            Node temp2 = parent.getRight();
                            while(true) {
                                if (temp.getRight().getValue() >= temp2.getValue()) {
                                    if (temp2.getRight() == null) {
                                        temp2.setRight(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getRight();
                                } else {
                                    if (temp2.getLeft() == null) {
                                        temp2.setLeft(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getLeft();
                                }
                            }
                        } else {
                            parent.setLeft(temp.getLeft());
                            Node temp2 = parent.getLeft();
                            while(true) {
                                if (temp.getRight().getValue() >= temp2.getValue()) {
                                    if (temp2.getRight() == null) {
                                        temp2.setRight(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getRight();
                                } else {
                                    if (temp2.getLeft() == null) {
                                        temp2.setLeft(new Node(temp.getRight().getValue(), temp.getRight().getLeft(), temp.getRight().getRight()));
                                        break;
                                    }
                                    temp2 = temp2.getLeft();
                                }
                            }
                        }
                        break;
                }

                return true;
            }
            if (element > temp.getValue()) {
                if (temp.getRight() != null) {
                    parent = temp;
                    temp = temp.getRight();
                } else return false;
            } else {
                if (temp.getLeft() != null) {
                    parent = temp;
                    temp = temp.getLeft();
                } else return false;
            }
        }
    } else return false;
}

}
