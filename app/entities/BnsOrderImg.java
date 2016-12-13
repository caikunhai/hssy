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
	* - time      : 2016/12/13 ��Ԫ at 23:26:34 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsOrderImg</p>
 *
 * <p>Description: Domain Object describing a BnsOrderImg entity</p>
 *
 */
@Entity (name="BnsOrderImg")
@Table (name="bns_order_img")
@NamedQueries({
	 @NamedQuery(name="BnsOrderImg.findAll", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg")
	,@NamedQuery(name="BnsOrderImg.findByOrderId", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.orderId = :orderId")
	,@NamedQuery(name="BnsOrderImg.findByOrderIdContaining", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.orderId like :orderId")

	,@NamedQuery(name="BnsOrderImg.findByFilename", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.filename = :filename")
	,@NamedQuery(name="BnsOrderImg.findByFilenameContaining", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.filename like :filename")

	,@NamedQuery(name="BnsOrderImg.findBySyn", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.syn = :syn")

	,@NamedQuery(name="BnsOrderImg.findByCreatedTime", query="SELECT bnsorderimg FROM BnsOrderImg bnsorderimg WHERE bnsorderimg.createdTime = :createdTime")

})

public class BnsOrderImg implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_SYN = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsOrderImg.findAll";
    public static final String FIND_BY_ORDERID = "BnsOrderImg.findByOrderId";
    public static final String FIND_BY_ORDERID_CONTAINING ="BnsOrderImg.findByOrderIdContaining";
    public static final String FIND_BY_FILENAME = "BnsOrderImg.findByFilename";
    public static final String FIND_BY_FILENAME_CONTAINING ="BnsOrderImg.findByFilenameContaining";
    public static final String FIND_BY_SYN = "BnsOrderImg.findBySyn";
    public static final String FIND_BY_CREATEDTIME = "BnsOrderImg.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @order_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @order_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-order_id@
    @Column(name="order_id"  , length=64 , nullable=true , unique=false)
    private String orderId; 
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
    public BnsOrderImg() {
    }

	/**
	* All field constructor 
	*/
    public BnsOrderImg(
       String id,
       String orderId,
       String filename,
       Integer syn,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setOrderId (orderId);
       setFilename (filename);
       setSyn (syn);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsOrderImg flat() {
	   return new BnsOrderImg(
          getId(),
          getOrderId(),
          getFilename(),
          getSyn(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-order_id@
    public String getOrderId() {
        return orderId;
    }
	
    public void setOrderId (String orderId) {
        this.orderId =  orderId;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_order_img@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (syn==null) syn=__DEFAULT_SYN;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_order_img@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (syn==null) syn=__DEFAULT_SYN;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
