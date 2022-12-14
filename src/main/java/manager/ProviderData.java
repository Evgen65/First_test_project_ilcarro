package manager;

import models.Find;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$")
        });
        list.add(new Object[]{new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$")
        });
        list.add(new Object[]{new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$")
        });
        list.add(new Object[]{new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$")
        });
        return list.iterator();
    }

}






