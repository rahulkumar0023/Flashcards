class Cat {

    // write static and instance variables
    String name;
    int age;
    static int counter = 0;


    public Cat(String name, int age) {
        // implement the constructor
        this.name = name;
        this.age = age;
            counter++;
        // do not forget to check the number of cats
    }

    public static int getNumberOfCats() {

        if(counter>5){
            for(int i = 6; i <= counter;i++){
                System.out.println("You have too many cats");
            }
        }

        return counter;
    }
}

