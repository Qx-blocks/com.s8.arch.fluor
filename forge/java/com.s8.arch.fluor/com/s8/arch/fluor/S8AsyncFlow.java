package com.s8.arch.fluor;

import java.util.List;

/**
 * 
 * @author pierreconvert
 *
 */
public interface S8AsyncFlow {
	

	public abstract S8User getMe();
	

	
	/**
	 * 
	 * @return
	 */
	public default String getMySpaceId() {
		return getMe().getPersonalSpaceId();
	}
	
	
	
	
	
	/**
	 * 
	 * @param profile
	 * @param runnable
	 */
	public abstract S8AsyncFlow runBlock(int force, S8CodeBlock runnable);

	
	
	/**
	 * 
	 * @param username
	 * @param user
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow getUser(String username, 
			S8ResultProcessor<S8User> user, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param user
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow selectUsers(S8Filter<S8User> filter, 
			S8ResultProcessor<List<S8User>> user, 
			S8ExceptionCatcher onException);
	
	
	
	/**
	 * 
	 * @param workspaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow accessMySpace(
			S8ResultProcessor<Object[]> onAccessed, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow exposeMySpace(Object[] exposure, 
			S8ResultProcessor<Long> onRebased, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param spaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow accessSpace(String spaceId, 
			S8ResultProcessor<Object[]> onAccessed, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow exposeSpace(String spaceId, Object[] exposure, 
			S8ResultProcessor<Long> onRebased, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 * @return 
	 */
	public abstract S8AsyncFlow commit(String repositoryAddress, String branchId, Object[] objects,
			S8ResultProcessor<Long> onCommitted, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract S8AsyncFlow cloneHead(String repositoryAddress, String branchId, 
			S8ResultProcessor<Object[]> onCloned, 
			S8ExceptionCatcher onException);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract S8AsyncFlow cloneVersion(String repositoryAddress, String branchId, long version,
			S8ResultProcessor<Object[]> onCloned, 
			S8ExceptionCatcher onException);
	
	
	
	/**
	 * Send and play 
	 */
	public void send();
	
	
	
	/**
	 * 
	 */
	public void play();
	
}
