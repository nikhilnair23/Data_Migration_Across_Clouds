use multi_cloud;

create table m_file(f_no int not null AUTO_INCREMENT, f_name varchar(20), user_id int, cloud1_id int, cloud2_id int,cloud3_id int, 
                     cloud4_id int, hash_code varchar(40),
                    primary key(f_no), 
                    foreign key(cloud1_id,cloud2_id,cloud3_id,cloud4_id) references m_cloud(c_id),foreign key(user_id) references m_user(m_id));



create table m_hash_code(h_no int not null AUTO_INCREMENT, user_id int, cloud_id int,file-id 