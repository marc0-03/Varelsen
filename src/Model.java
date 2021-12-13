import java.util.ArrayList;

public class Model {
    private Varelsen[][] Varelser;
    private Food[][] Food;
    private int width;
    private int height;

    public Model(int width, int height) {
        Varelser = new Varelsen[width][height];
        Food = new Food[width][height];
        this.width = width;
        this.height = height;
        for (int w = 0; w<width; w++) {
            for (int h = 0; h<height; h++) {
                if (Math.random()<0.05) {
                    Varelser[w][h] = new Varelsen(10);
                } else if (Math.random()<0.05) {
                    Food[w][h] = new Food(5);
                }
            }
        }
    }



    public void update(Varelsen[][] Varelser, Food[][] Food) {
        //ArrayList<Integer> x = new ArrayList<>();
        //ArrayList<Integer> y = new ArrayList<>();
        int around = 0;
        Food closestFood;

        for (int w = 0; w< Varelser.length; w++) {
            for (int h = 0; h < Varelser[0].length; h++) {
                if (Varelser[w][h]!=null)
                around = checkAround(w,h,Varelser,Food);
                if (around!=0) {
                    closestFood = closestFood(w,h,Food);
                } else {

                }
            }
        }

        /*
        for (int i = 0; i<y.size(); i++) {
            cellTable[x.get(i)][y.get(i)].changeAlive();
        }
         */



    }

    private Food closestFood(int w, int h, Food[][] food) {
        Food tempFood = null;
        double tempLength = 0;
        for (int width = 0; width< food.length; width++) {
            for (int height = 0; height < food[0].length; height++) {
                if (tempFood==null) {
                    tempFood=food[width][height];
                    tempLength=Math.sqrt(Math.pow(w-width,2)+Math.pow(h-height,2));
                } else {
                    if (tempLength>=Math.sqrt(Math.pow(w-width,2)+Math.pow(h-height,2))) {
                        tempFood=food[width][height];
                        tempLength=Math.sqrt(Math.pow(w-width,2)+Math.pow(h-height,2));
                    }
                }
            }
        }
        return tempFood;
    }


    public int checkAround(int w, int h, Varelsen[][] Varelser, Food[][] Food) {
        int around = 0;
        int x;
        int y;

        for (x = -2; x<3; x++) {
            for (y = -2; y<3; y++) {
                    if ((w+x > Varelser.length-1 || w+x < 0) || (h+y > Varelser[0].length-1 || h+y < 0)) {

                    } else {
                        if (Food[w+x][h+y] != null) {
                            around++;
                        }
                    }
            }
        }
        return around;
    }


    public Varelsen[][] getVarelser() {
        return Varelser;
    }
    public Food[][] getFood() {
        return Food;
    }
}
