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
	* - time      : 2017/01/10 ��Ԫ at 09:50:07 CST
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
 * <p>Title: BnsWorks</p>
 *
 * <p>Description: Domain Object describing a BnsWorks entity</p>
 *
 */
@Entity (name="BnsWorks")
@Table (name="bns_works")
@NamedQueries({
	 @NamedQuery(name="BnsWorks.findAll", query="SELECT bnsworks FROM BnsWorks bnsworks")
	,@NamedQuery(name="BnsWorks.findByCompany", query="SELECT bnsworks FROM BnsWorks bnsworks WHERE bnsworks.company = :company")
	,@NamedQuery(name="BnsWorks.findByCompanyContaining", query="SELECT bnsworks FROM BnsWorks bnsworks WHERE bnsworks.company like :company")

	,@NamedQuery(name="BnsWorks.findByFilename", query="SELECT bnsworks FROM BnsWorks bnsworks WHERE bnsworks.filename = :filename")
	,@NamedQuery(name="BnsWorks.findByFilenameContaining", query="SELECT bnsworks FROM BnsWorks bnsworks WHERE bnsworks.filename like :filename")

	,@NamedQuery(name="BnsWorks.findByCreatedTime", query="SELECT bnsworks FROM BnsWorks bnsworks WHERE bnsworks.createdTime = :createdTime")

})

public class BnsWorks implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BnsWorks.findAll";
    public static final String FIND_BY_COMPANY = "BnsWorks.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsWorks.findByCompanyContaining";
    public static final String FIND_BY_FILENAME = "BnsWorks.findByFilename";
    public static final String FIND_BY_FILENAME_CONTAINING ="BnsWorks.findByFilenameContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsWorks.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-company@
    @Column(name="company"  , length=64 , nullable=true , unique=false)
    private String company; 
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
    public BnsWorks() {
    }

	/**
	* All field constructor 
	*/
    public BnsWorks(
       String id,
       String company,
       String filename,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setFilename (filename);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsWorks flat() {
	   return new BnsWorks(
          getId(),
          getCompany(),
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
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-company@
    public String getCompany() {
        return company;
    }
	
    public void setCompany (String company) {
        this.company =  company;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_works@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_works@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
