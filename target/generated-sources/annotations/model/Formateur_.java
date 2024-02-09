package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Formateur.class)
public abstract class Formateur_ {

	public static volatile ListAttribute<Formateur, Formation> formations;
	public static volatile SingularAttribute<Formateur, String> CIN;
	public static volatile SingularAttribute<Formateur, String> nom;
	public static volatile SingularAttribute<Formateur, Integer> age;

	public static final String FORMATIONS = "formations";
	public static final String C_IN = "CIN";
	public static final String NOM = "nom";
	public static final String AGE = "age";

}

