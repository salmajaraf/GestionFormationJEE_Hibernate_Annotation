package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Formation.class)
public abstract class Formation_ {

	public static volatile SingularAttribute<Formation, String> theme;
	public static volatile SingularAttribute<Formation, Integer> id;
	public static volatile ListAttribute<Formation, Formateur> formateurs;
	public static volatile SingularAttribute<Formation, Lieu> lieu;

	public static final String THEME = "theme";
	public static final String ID = "id";
	public static final String FORMATEURS = "formateurs";
	public static final String LIEU = "lieu";

}

