public class ManyPeopleDriver {
    public static void main(String[] args) {
        String[] names = {
                "Sam", "Chris", "Zoe", "Sandy", "Terry", "Alex","Jesse", "Riley",
        };
        int[] ages = {
                5,10,15,20,25,30,35,40,
        };
        for(int k=0; k < names.length; k++) {
            Person p = new Person(names[k], ages[k]);
            System.out.println(p);
        }
    }
}
