package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lieu.class)
public abstract class Lieu_ {

	public static volatile SingularAttribute<Lieu, String> ville;
	public static volatile SingularAttribute<Lieu, String> adresse;
	public static volatile SingularAttribute<Lieu, Integer> idLieu;

	public static final String VILLE = "ville";
	public static final String ADRESSE = "adresse";
	public static final String ID_LIEU = "idLieu";

}

