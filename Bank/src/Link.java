public class Link {

    public static void main(String[] args){
        User user1 = new User("Abdulrhman", "AlAnzi", "si39x", "@gmail.com", "0536412886" , 202321505, 5300);
        user1.adressAdderManual("KSA", "DAHRAN", "EASTERN PROVINCE", "21A-4th St", "90302");
        System.out.println(user1.displayUserInfo());

        User user2 = new User("Ziyad", "Qahtani", "ahm31", "@yahoo.com", "051412355", 202321503, 13054);
        user2.adressAdderManual("KSA", "RIYADH", "NAJID PROVINCE", "24B-2nd St", "31931");
        System.out.println(user2.displayUserInfo());
    }

}
