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
	* - time      : 2016/09/28 ��Ԫ at 17:50:23 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
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
 * <p>Title: SysLog</p>
 *
 * <p>Description: Domain Object describing a SysLog entity</p>
 *
 */
@Entity (name="SysLog")
@Table (name="sys_log")
@NamedQueries({
	 @NamedQuery(name="SysLog.findAll", query="SELECT syslog FROM SysLog syslog")
	,@NamedQuery(name="SysLog.findByTag", query="SELECT syslog FROM SysLog syslog WHERE syslog.tag = :tag")
	,@NamedQuery(name="SysLog.findByTagContaining", query="SELECT syslog FROM SysLog syslog WHERE syslog.tag like :tag")

	,@NamedQuery(name="SysLog.findByContent", query="SELECT syslog FROM SysLog syslog WHERE syslog.content = :content")
	,@NamedQuery(name="SysLog.findByContentContaining", query="SELECT syslog FROM SysLog syslog WHERE syslog.content like :content")

	,@NamedQuery(name="SysLog.findByIp", query="SELECT syslog FROM SysLog syslog WHERE syslog.ip = :ip")
	,@NamedQuery(name="SysLog.findByIpContaining", query="SELECT syslog FROM SysLog syslog WHERE syslog.ip like :ip")

	,@NamedQuery(name="SysLog.findByType", query="SELECT syslog FROM SysLog syslog WHERE syslog.type = :type")

	,@NamedQuery(name="SysLog.findByCreatedTime", query="SELECT syslog FROM SysLog syslog WHERE syslog.createdTime = :createdTime")

})

public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "SysLog.findAll";
    public static final String FIND_BY_TAG = "SysLog.findByTag";
    public static final String FIND_BY_TAG_CONTAINING ="SysLog.findByTagContaining";
    public static final String FIND_BY_CONTENT = "SysLog.findByContent";
    public static final String FIND_BY_CONTENT_CONTAINING ="SysLog.findByContentContaining";
    public static final String FIND_BY_IP = "SysLog.findByIp";
    public static final String FIND_BY_IP_CONTAINING ="SysLog.findByIpContaining";
    public static final String FIND_BY_TYPE = "SysLog.findByType";
    public static final String FIND_BY_CREATEDTIME = "SysLog.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @tag-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @tag-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-tag@
    @Column(name="tag"  , length=255 , nullable=true , unique=false)
    private String tag; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @content-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @content-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-content@
    @Column(name="content"   , nullable=true , unique=false)
    private String content; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ip-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ip-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ip@
    @Column(name="ip"  , length=64 , nullable=true , unique=false)
    private String ip; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name="type"   , nullable=true , unique=false)
    private Integer type; 
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
    public SysLog() {
    }

	/**
	* All field constructor 
	*/
    public SysLog(
       Long id,
       String tag,
       String content,
       String ip,
       Integer type,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setTag (tag);
       setContent (content);
       setIp (ip);
       setType (type);
       setCreatedTime (createdTime);
       //parents
    }

	public SysLog flat() {
	   return new SysLog(
          getId(),
          getTag(),
          getContent(),
          getIp(),
          getType(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-tag@
    public String getTag() {
        return tag;
    }
	
    public void setTag (String tag) {
        this.tag =  tag;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-content@
    public String getContent() {
        return content;
    }
	
    public void setContent (String content) {
        this.content =  content;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ip@
    public String getIp() {
        return ip;
    }
	
    public void setIp (String ip) {
        this.ip =  ip;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public Integer getType() {
        return type;
    }
	
    public void setType (Integer type) {
        this.type =  type;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-sys_log@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-sys_log@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
