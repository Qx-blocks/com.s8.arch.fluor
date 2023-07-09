package com.s8.arch.fluor;

import com.s8.arch.fluor.outputs.GetUserS8AsyncOutput;
import com.s8.arch.fluor.outputs.ObjectsListS8AsyncOutput;
import com.s8.arch.fluor.outputs.PutUserS8AsyncOutput;
import com.s8.arch.fluor.outputs.RepoCreationS8AsyncOutput;
import com.s8.arch.fluor.outputs.BranchCreationS8AsyncOutput;
import com.s8.arch.fluor.outputs.BranchExposureS8AsyncOutput;
import com.s8.arch.fluor.outputs.BranchVersionS8AsyncOutput;
import com.s8.arch.fluor.outputs.SpaceExposureS8AsyncOutput;
import com.s8.arch.fluor.outputs.SpaceVersionS8AsyncOutput;
import com.s8.io.bytes.alpha.Bool64;


/**
 * 
 * @author pierreconvert
 *
 */
public interface S8AsyncFlow {
	
	
	public final static long CREATE_SPACE_IF_NOT_PRESENT = Bool64.BIT02;
	
	public final static long SAVE_IMMEDIATELY_AFTER = Bool64.BIT03;
	
	public final static long SHOULD_NOT_OVERRIDE = Bool64.BIT04;


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
			S8OutputProcessor<GetUserS8AsyncOutput> user, long options);
	
	
	/**
	 * 
	 * @param username
	 * @param user
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow getUser(String username, S8OutputProcessor<GetUserS8AsyncOutput> user) {
		return getUser(username, user, 0x0L);
	}
	
	

	/**
	 * 
	 * @param username
	 * @param user
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow putUser(S8User user,
			S8OutputProcessor<PutUserS8AsyncOutput> onInserted, long options);
	
	
	/**
	 * 
	 * @param username
	 * @param user
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow putUser(S8User user, S8OutputProcessor<PutUserS8AsyncOutput> onInserted) {
		return putUser(user, onInserted, 0x0L);
	}


	
	/**
	 * 
	 * @param user
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow selectUsers(S8Filter<S8User> filter, 
			S8OutputProcessor<ObjectsListS8AsyncOutput<S8User>> onSelected, long options);
	
	
	/**
	 * 
	 * @param user
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow selectUsers(S8Filter<S8User> filter, 
			S8OutputProcessor<ObjectsListS8AsyncOutput<S8User>> onSelected) {
		return selectUsers(filter, onSelected, 0x0L);
	}


	/**
	 * 
	 * @param workspaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow accessMySpace(S8OutputProcessor<SpaceExposureS8AsyncOutput> onAccessed, long options);
	
	
	/**
	 * 
	 * @param workspaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow accessMySpace(S8OutputProcessor<SpaceExposureS8AsyncOutput> onAccessed) {
		return accessMySpace(onAccessed, 0x0L);
	}


	
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow exposeMySpace(Object[] exposure, 
			S8OutputProcessor<SpaceVersionS8AsyncOutput> onRebased, 
			long options);
	
	
	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow exposeMySpace(Object[] exposure, 
			S8OutputProcessor<SpaceVersionS8AsyncOutput> onRebased) {
		return exposeMySpace(exposure, onRebased, 0x0L);
	}



	/**
	 * 
	 * @param spaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow accessSpace(String spaceId, 
			S8OutputProcessor<SpaceExposureS8AsyncOutput> onAccessed, long options);
	
	
	
	/**
	 * 
	 * @param spaceId
	 * @param onAccessed
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow accessSpace(String spaceId, 
			S8OutputProcessor<SpaceExposureS8AsyncOutput> onAccessed) {
		return accessSpace(spaceId, onAccessed, 0x0L);
	}

	

	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public abstract S8AsyncFlow exposeSpace(String spaceId, Object[] exposure, 
			S8OutputProcessor<SpaceVersionS8AsyncOutput> onRebased, 
			long options);


	/**
	 * 
	 * @param exposure
	 * @param onRebased
	 * @param onException
	 * @return 
	 */
	public default S8AsyncFlow exposeSpace(String spaceId, Object[] exposure, 
			S8OutputProcessor<SpaceVersionS8AsyncOutput> onRebased) {
		return exposeMySpace(exposure, onRebased, 0x0L);
	}
	
	



	/**
	 * 
	 * @param pre
	 * @param post
	 * @return 
	 */
	public abstract S8AsyncFlow createRepository(String repositoryAddress, 
			S8OutputProcessor<RepoCreationS8AsyncOutput> onCommitted, long options);
	
	
	

	/**
	 * 
	 * @param pre
	 * @param post
	 * @return 
	 */
	public abstract S8AsyncFlow createBranch(String repositoryAddress, String branchId, 
			S8OutputProcessor<BranchCreationS8AsyncOutput> onCommitted, long options);
	

	
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 * @return 
	 */
	public abstract S8AsyncFlow commit(String repositoryAddress, String branchId, Object[] objects,
			S8OutputProcessor<BranchVersionS8AsyncOutput> onCommitted, long options);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 * @return 
	 */
	public default S8AsyncFlow commit(String repositoryAddress, String branchId, Object[] objects,
			S8OutputProcessor<BranchVersionS8AsyncOutput> onCommitted) {
		return commit(repositoryAddress, branchId, objects, onCommitted, 0x0L);
	}


	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract S8AsyncFlow cloneHead(String repositoryAddress, String branchId, 
			S8OutputProcessor<BranchExposureS8AsyncOutput> onCloned, long options);
	
	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public default S8AsyncFlow cloneHead(String repositoryAddress, String branchId, 
			S8OutputProcessor<BranchExposureS8AsyncOutput> onCloned) {
		return cloneHead(repositoryAddress, branchId, onCloned, 0x0L);
	}


	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public abstract S8AsyncFlow cloneVersion(String repositoryAddress, String branchId, long version,
			S8OutputProcessor<BranchExposureS8AsyncOutput> onCloned, long options);

	
	/**
	 * 
	 * @param pre
	 * @param post
	 */
	public default S8AsyncFlow cloneVersion(String repositoryAddress, String branchId, long version,
			S8OutputProcessor<BranchExposureS8AsyncOutput> onCloned) {
		return cloneVersion(repositoryAddress, branchId, version, onCloned, 0x0L);
	}



	/**
	 * Send and play 
	 */
	public void send();



	/**
	 * 
	 */
	public void play();

}
