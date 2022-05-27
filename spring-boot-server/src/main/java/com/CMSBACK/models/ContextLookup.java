/*package com.CMSBACK.models;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
	public class ContextLookup implements ApplicationContextAware {

	    private static ApplicationContext sApplicationContext;
	    @Override
	    public void setApplicationContext(org.springframework.context.ApplicationContext aApplicationContext)
				throws BeansException {
	        setContext( aApplicationContext );

			// TODO Auto-generated method stub
			
		}
	    public static Object getCurrentEntity() {
	        return currentEntity;
	    }

	    public static void setCurrentEntity(Object currentEntity) {
	        ContextLookup.currentEntity = currentEntity;
	    }

	    private static Object currentEntity;


	    public static void setContext( org.springframework.context.ApplicationContext aApplicationContext ) {
	        sApplicationContext = (ApplicationContext) aApplicationContext;
	    }

	    protected static ApplicationContext getApplicationContext() {
	        return sApplicationContext;
	    }

	    public static Object getBean( String aName ) {
	        if ( sApplicationContext != null ) {
	            return ((BeanFactory) sApplicationContext).getBean( aName );
	        }
	        return null;
	    }

	    public static <T> T getBean( Class<T> aClass ) {
	        if ( sApplicationContext != null ) {
	            return ((BeanFactory) sApplicationContext).getBean( aClass );
	        }
	        return null;
	    }

		
	}*/

