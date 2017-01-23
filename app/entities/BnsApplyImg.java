/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2017/01/21 ��Ԫ at 17:19:31 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsApplyImg</p>
 *
 * <p>Description: Domain Object describing a BnsApplyImg entity</p>
 *
 */
@Entity (name="BnsApplyImg")
@Table (name="bns_apply_img")
@NamedQueries({
	 @NamedQuery(name="BnsApplyImg.findAll", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg")
	,@NamedQuery(name="BnsApplyImg.findByApply", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg WHERE bnsapplyimg.apply = :apply")
	,@NamedQuery(name="BnsApplyImg.findByApplyContaining", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg WHERE bnsapplyimg.apply like :apply")

	,@NamedQuery(name="BnsApplyImg.findByFilename", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg WHERE bnsapplyimg.filename = :filename")
	,@NamedQuery(name="BnsApplyImg.findByFilenameContaining", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg WHERE bnsapplyimg.filename like :filename")

	,@NamedQuery(name="BnsApplyImg.findByCreatedTime", query="SELECT bnsapplyimg FROM BnsApplyImg bnsapplyimg WHERE bnsapplyimg.createdTime = :createdTime")

})

public class BnsApplyImg implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BnsApplyImg.findAll";
    public static final String FIND_BY_APPLY = "BnsApplyImg.findByApply";
    public static final String FIND_BY_APPLY_CONTAINING ="BnsApplyImg.findByApplyContaining";
    public static final String FIND_BY_FILENAME = "BnsApplyImg.findByFilename";
    public static final String FIND_BY_FILENAME_CONTAINING ="BnsApplyImg.findByFilenameContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsApplyImg.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @apply-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @apply-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-apply@
    @Column(name="apply"  , length=64 , nullable=true , unique=false)
    private String apply; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @filename-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @filename-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-filename@
    @Column(name="filename"  , length=100 , nullable=true , unique=false)
    private String filename; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_time@
    @Column(name="created_time"   , nullable=true , unique=false)
    private Timestamp createdTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public BnsApplyImg() {
    }

	/**
	* All field constructor 
	*/
    public BnsApplyImg(
       String id,
       String apply,
       String filename,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setApply (apply);
       setFilename (filename);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsApplyImg flat() {
	   return new BnsApplyImg(
          getId(),
          getApply(),
          getFilename(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-apply@
    public String getApply() {
        return apply;
    }
	
    public void setApply (String apply) {
        this.apply =  apply;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-filename@
    public String getFilename() {
        return filename;
    }
	
    public void setFilename (String filename) {
        this.filename =  filename;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_apply_img@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_apply_img@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
