// Product Class
class Burger {
    private String bun;
    private boolean cheese;
    private boolean lettuce;

    private Burger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
    }

    public void display() {
        System.out.println("Burger with " + bun + ", Cheese: " + cheese + ", Lettuce: " + lettuce);
    }

    public static class BurgerBuilder {
        private String bun;
        private boolean cheese;
        private boolean lettuce;

        public BurgerBuilder(String bun) { this.bun = bun; }
        public BurgerBuilder addCheese() { this.cheese = true; return this; }
        public BurgerBuilder addLettuce() { this.lettuce = true; return this; }
        public Burger build() { return new Burger(this); }
    }
}

// Client
public class BuilderPattern {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder("Sesame Bun").addCheese().addLettuce().build();
        burger.display();
    }
}

