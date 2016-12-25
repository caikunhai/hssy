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
	* - time      : 2016/12/24 ��Ԫ at 23:37:41 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsFile</p>
 *
 * <p>Description: Domain Object describing a BnsFile entity</p>
 *
 */
@Entity (name="BnsFile")
@Table (name="bns_file")
@NamedQueries({
	 @NamedQuery(name="BnsFile.findAll", query="SELECT bnsfile FROM BnsFile bnsfile")
	,@NamedQuery(name="BnsFile.findByFather", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.father = :father")
	,@NamedQuery(name="BnsFile.findByFatherContaining", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.father like :father")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsFile.findByFilename", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.filename = :filename")
	,@NamedQuery(name="BnsFile.findByFilenameContaining", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.filename like :filename")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsFile.findBySyn", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.syn = :syn")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsFile.findByCreatedTime", query="SELECT bnsfile FROM BnsFile bnsfile WHERE bnsfile.createdTime = :createdTime")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
})
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-annotations@
//MP-MANAGED-ADDED-AREA-ENDING @custom-annotations@
public class BnsFile implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_SYN = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsFile.findAll";
    public static final String FIND_BY_FATHER = "BnsFile.findByFather";
    public static final String FIND_BY_FATHER_CONTAINING ="BnsFile.findByFatherContaining";
    public static final String FIND_BY_FILENAME = "BnsFile.findByFilename";
    public static final String FIND_BY_FILENAME_CONTAINING ="BnsFile.findByFilenameContaining";
    public static final String FIND_BY_SYN = "BnsFile.findBySyn";
    public static final String FIND_BY_CREATEDTIME = "BnsFile.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @father-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @father-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-father@
    @Column(name="father"  , length=64 , nullable=true , unique=false)
    private String father; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @filename-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @filename-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-filename@
    @Column(name="filename"  , length=100 , nullable=true , unique=false)
    private String filename; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @syn-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @syn-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-syn@
    @Column(name="syn"   , nullable=true , unique=false)
    private Integer syn; 
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
    public BnsFile() {
    }

	/**
	* All field constructor 
	*/
    public BnsFile(
       Long id,
       String father,
       String filename,
       Integer syn,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setFather (father);
       setFilename (filename);
       setSyn (syn);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsFile flat() {
	   return new BnsFile(
          getId(),
          getFather(),
          getFilename(),
          getSyn(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-father@
    public String getFather() {
        return father;
    }
	
    public void setFather (String father) {
        this.father =  father;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-syn@
    public Integer getSyn() {
        return syn;
    }
	
    public void setSyn (Integer syn) {
        this.syn =  syn;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_file@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (syn==null) syn=__DEFAULT_SYN;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_file@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (syn==null) syn=__DEFAULT_SYN;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
