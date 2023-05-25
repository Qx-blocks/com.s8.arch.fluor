package com.s8.arch.fluor;

import java.util.List;

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
	

	public abstract S8User getMe();
	
	
	/**
	 * 
	 * @param username
	 * @param user
	 * @param onException
	 */
	public abstract void getUser(String username, S8ResultProcessor<S8User> user, S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param user
	 * @param onException
	 */
	public abstract void scanUsers(S8Filter<S8User> filter, S8ResultProcessor<List<S8User>> user, S8ExceptionCatcher onException);
	
	
	
	/**
	 * 
	 * @return
	 */
	public default String getMySpaceId() {
		return getMe().getPersonalSpaceId();
	}
	
	
	
	/**
	 * 
	 * @param workspaceId
	 * @param onAccessed
	 * @param onException
	 */
	public abstract void accessMySpace(S8ResultProcessor<Object[]> onAccessed, S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 */
	public abstract void exposeMySpace(Object[] exposure, S8ResultProcessor<Long> onRebased, S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param spaceId
	 * @param onAccessed
	 * @param onException
	 */
	public abstract void accessSpace(String spaceId, S8ResultProcessor<Object[]> onAccessed, S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 */
	public abstract void exposeSpace(String spaceId, Object[] exposure, S8ResultProcessor<Long> onRebased, S8ExceptionCatcher onException);
	
	
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
