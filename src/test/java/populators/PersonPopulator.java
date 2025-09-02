package populators;

import app.daos.DolphinDAO;
import app.entities.Fee;
import app.entities.Person;
import app.entities.PersonDetail;

import java.time.LocalDate;

public class PersonPopulator {
    public static Person[] populate (DolphinDAO dao){
        Fee f1 = Fee.builder().amount(125).payDate(LocalDate.of(2023, 8, 25)).build();
        Fee f2 = Fee.builder().amount(150).payDate(LocalDate.of(2023, 7, 19)).build();


        Person p1 = Person.builder()
                .name("Bo")
                .build();

        PersonDetail pd1 = PersonDetail.builder()
                .person(p1)
                .zip(3050)
                .city("Humlebæk")
                .Address("Baunebjergvej")
                .age(65)
                .build();
        p1.addPersonDetail(pd1);

        Person p2 = Person.builder()
                .name("Emil")
                .build();

        PersonDetail pd2 = PersonDetail.builder()
                .person(p2)
                .zip(2860)
                .city("Søborg")
                .Address("Tobaksvejen")
                .age(30)
                .build();
        p2.addPersonDetail(pd2);

        return new Person[]{p1, p2};
    }
}
