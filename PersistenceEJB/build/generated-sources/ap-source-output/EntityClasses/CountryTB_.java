package EntityClasses;

import EntityClasses.UserTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T23:41:54")
@StaticMetamodel(CountryTB.class)
public class CountryTB_ { 

    public static volatile SingularAttribute<CountryTB, Integer> id;
    public static volatile SingularAttribute<CountryTB, String> countryName;
    public static volatile CollectionAttribute<CountryTB, UserTB> userTBCollection;

}