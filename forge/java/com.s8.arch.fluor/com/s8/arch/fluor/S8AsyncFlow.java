package com.s8.arch.fluor;

/**
 * 
 * @author pierreconvert
 *
 */
public interface S8AsyncFlow {
	
	
	

	
	
	/**
	 * 
	 * @param profile
	 * @param runnable
	 */
	public abstract S8AsyncFlow prior(int force, S8CodeBlock runnable);
	
	
	
	/**
	 * 
	 * @param profile
	 * @param runnable
	 */
	public abstract S8AsyncFlow then(int force, S8CodeBlock runnable);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract void commit(String repositoryAddress, 
			String branchId, 
			Object[] objects,
			S8ResultProcessor<Long> onCommitted, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract void cloneHead(String repositoryAddress, 
			String branchId, 
			S8ResultProcessor<Object[]> onCloned, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract void cloneVersion(
			String repositoryAddress, 
			String branchId, 
			long version,
			S8ResultProcessor<Object[]> onCloned, 
			S8ExceptionCatcher onException);
	
	
	public void send();
	
	
}
