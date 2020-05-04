class Application {

    String name;

    void run(String[] args) {
        System.out.println(this.name);
        for(String s : args){
            System.out.println(s);
        }
    }
}