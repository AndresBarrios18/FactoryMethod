    package com.mycompany.crud ;

    import java.sql.Connection ;
    import java.sql.PreparedStatement ;
    import java.sql.ResultSet ;
    import java.sql.SQLException ;

    public class UniversidadDAO implements CRUD<Universidad> {

        private static UniversidadDAO instance;
        private Connection connection;

        private UniversidadDAO() {
            // Aquí deberías inicializar la conexión a la base de datos
            // Esto es solo un ejemplo, deberías proporcionar tus propios detalles de conexión
            connection = MySqlConnection.getConnection();
        }

        public static synchronized UniversidadDAO getInstance() {
            if (instance == null) {
                instance = new UniversidadDAO();
            }
            return instance;
        }

        @Override
        public void create(Universidad universidad, Storage storage) {
            try {
                String query = "INSERT INTO universidades (id_universidad, nombre_universidad, direccion, ciudad) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, universidad.getIdUniversidad());
                statement.setString(2, universidad.getNombreUniversidad());
                statement.setString(3, universidad.getDireccion());
                statement.setString(4, universidad.getCiudad());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Universidad read(int id) {
            Universidad universidad = null;
            try {
                String query = "SELECT * FROM universidades WHERE id_universidad=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    universidad = new Universidad(resultSet.getInt("id_universidad"), resultSet.getString("nombre_universidad"), resultSet.getString("direccion"), resultSet.getString("ciudad"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return universidad;
        }

        @Override
        public void update(Universidad universidad) {
            try {
                String query = "UPDATE universidades SET nombre_universidad=?, direccion=?, ciudad=? WHERE id_universidad=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, universidad.getNombreUniversidad());
                statement.setString(2, universidad.getDireccion());
                statement.setString(3, universidad.getCiudad());
                statement.setInt(4, universidad.getIdUniversidad());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void delete(int id) {
            try {
                String query = "DELETE FROM universidades WHERE id_universidad=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

