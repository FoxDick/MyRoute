package online.myroute.model.db;

import online.myroute.components.PanelFieldType;
import online.myroute.model.anotations.DataTableColumnMeta;
import online.myroute.model.anotations.DataTableMeta;
import online.myroute.model.anotations.PanelFieldMeta;
import online.myroute.model.anotations.PanelMeta;
import online.myroute.repositories.AdminRepository;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins", schema = "public")
@DataTableMeta(name = "Администраторы системы", emptyDataText = "Нет данных для отображения")
@PanelMeta(repositoryClass = AdminRepository.class)
public class AdminEntity {
    @PanelFieldMeta(name = "Идентификатор", description = "Идентификатор", type = PanelFieldType.TEXT, readOnly = true)
    private int id;
    @DataTableColumnMeta(name = "Имя пользователя", description = "Имя пользователя", priority = 2)
    @PanelFieldMeta(name = "Имя пользователя", description = "Имя пользователя", priority = 2, type = PanelFieldType.TEXT)
    private String name;
    @DataTableColumnMeta(name = "Email", description = "Электронный адрес пользователя", priority = 1)
    @PanelFieldMeta(name = "Email", description = "Электронный адрес пользователя", priority = 1, type = PanelFieldType.TEXT)
    private String email;
    @PanelFieldMeta(name = "Пароль", description = "Пароль", priority = 3, type = PanelFieldType.PASSWORD)
    private String password;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

}
