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
	* - time      : 2017/01/12 ��Ԫ at 15:24:13 CST
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
 * <p>Title: BnsHotelImg</p>
 *
 * <p>Description: Domain Object describing a BnsHotelImg entity</p>
 *
 */
@Entity (name="BnsHotelImg")
@Table (name="bns_hotel_img")
@NamedQueries({
	 @NamedQuery(name="BnsHotelImg.findAll", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg")
	,@NamedQuery(name="BnsHotelImg.findByHotel", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg WHERE bnshotelimg.hotel = :hotel")
	,@NamedQuery(name="BnsHotelImg.findByHotelContaining", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg WHERE bnshotelimg.hotel like :hotel")

	,@NamedQuery(name="BnsHotelImg.findByFilename", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg WHERE bnshotelimg.filename = :filename")
	,@NamedQuery(name="BnsHotelImg.findByFilenameContaining", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg WHERE bnshotelimg.filename like :filename")

	,@NamedQuery(name="BnsHotelImg.findByCreatedTime", query="SELECT bnshotelimg FROM BnsHotelImg bnshotelimg WHERE bnshotelimg.createdTime = :createdTime")

})

public class BnsHotelImg implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BnsHotelImg.findAll";
    public static final String FIND_BY_HOTEL = "BnsHotelImg.findByHotel";
    public static final String FIND_BY_HOTEL_CONTAINING ="BnsHotelImg.findByHotelContaining";
    public static final String FIND_BY_FILENAME = "BnsHotelImg.findByFilename";
    public static final String FIND_BY_FILENAME_CONTAINING ="BnsHotelImg.findByFilenameContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsHotelImg.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @hotel-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @hotel-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-hotel@
    @Column(name="hotel"  , length=64 , nullable=true , unique=false)
    private String hotel; 
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
    public BnsHotelImg() {
    }

	/**
	* All field constructor 
	*/
    public BnsHotelImg(
       String id,
       String hotel,
       String filename,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setHotel (hotel);
       setFilename (filename);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsHotelImg flat() {
	   return new BnsHotelImg(
          getId(),
          getHotel(),
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
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-hotel@
    public String getHotel() {
        return hotel;
    }
	
    public void setHotel (String hotel) {
        this.hotel =  hotel;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_hotel_img@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_hotel_img@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
