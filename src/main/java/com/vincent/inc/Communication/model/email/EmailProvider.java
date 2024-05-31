package com.vincent.inc.Communication.model.email;

import com.vincent.inc.viesspringutils.model.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email_provider")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailProvider extends UserModel {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private String host;
    
    @Column
    private int port;
    
    @Column
    private String username;
    
    @Column
    private String password;

    @Builder.Default
    @Column(columnDefinition = "varchar(10) default 'smtp'")
    private String protocol = "smtp";
    
    @Builder.Default
    @Column(columnDefinition = "BIT(1) default 1")
    private boolean auth = true;
    
    @Builder.Default
    @Column(columnDefinition = "BIT(1) default 1")
    private boolean starttls = true;
}
