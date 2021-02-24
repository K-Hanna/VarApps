package functions.sa;

class MyDoc {
    private String name, path;

    MyDoc(String name, String path){
        this.name = name;
        this.path = path;
    }

    String getName() {
        return name;
    }

    String getPath () {
        return path;
    }

    @Override
    public String toString(){
        return name + " " + path;
    }
}
