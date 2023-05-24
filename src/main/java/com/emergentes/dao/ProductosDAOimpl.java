package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOimpl extends ConexionDB implements ProductosDAO {

    @Override
    public void insert(Productos cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into productos (descripcion,cantidad,precio,categorias) values (?,?,?,?)");
            ps.setString(1, cliente.getDescripcion());
            ps.setInt(2, cliente.getCantidad());
            ps.setFloat(3, cliente.getPrecio());
            ps.setString(4, cliente.getCategorias());
            ps.executeUpdate();
            this.desconectar();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Productos cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update productos "
                    + "set descripcion=?, cantidad=? , precio=?, categorias=? where id=?");
            ps.setString(1, cliente.getDescripcion());
            ps.setInt(2, cliente.getCantidad());
            ps.setFloat(3, cliente.getPrecio());
            ps.setString(4, cliente.getCategorias());
            ps.setInt(5, cliente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from productos where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos cli = new Productos();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from productos where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setDescripcion(rs.getString("descripcion"));
                cli.setCantidad(rs.getInt("cantidad"));
                cli.setPrecio(rs.getFloat("precio"));
                cli.setCategorias(rs.getString("categorias"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Productos> getAll() throws Exception {
        List<Productos> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from productos");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Productos>();
            while (rs.next()) {
                Productos cli = new Productos();
                cli.setId(rs.getInt("id"));
                cli.setDescripcion(rs.getString("descripcion"));
                cli.setCantidad(rs.getInt("cantidad"));
                cli.setPrecio(rs.getFloat("precio"));
                cli.setCategorias(rs.getString("categorias"));

                lista.add(cli);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
