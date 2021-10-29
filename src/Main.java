import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        Inmobiliaria inmobiliaria = new Inmobiliaria("Inmobiliaria Los Sauces", "Bogotá D.C", "Calle 93 No 11-43", "123456789");
        Inmueble inmueble = new Inmueble(1032500358, "Julia", "Marin", "Bogotá", "Calle 145 No 11-23", false, 120000, 1500, true);
        inmueble.setCommission();
        List<Cliente> clientes = new ArrayList<>();

        boolean salir = false;

        System.out.println("Portal contratos - " + inmobiliaria.getNombreInmobiliaria());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!salir) {
            try {
                System.out.println("Menu principal");
                System.out.println("Seleccione una opción: \n 1. Ver datos inmueble \n 2. Crear cliente \n 3. Listar Clientes \n 4. Crear contrato \n 5. Listar contratos \n 6. Eliminar clientes \n 7. Salir");
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        inmueble.printPropertyInformation();
                        break;
                    case 2:
                        Cliente cliente = new Cliente();
                        System.out.println("Creación de cliente");
                        System.out.println("Ingrese la identificación");
                        long id = Long.parseLong(br.readLine());
                        cliente.setIdentificacion(id);
                        System.out.println("Ingrese los nombres");
                        String nombre = br.readLine();
                        cliente.setNombre(nombre);
                        System.out.println("Ingrese los apellidos");
                        String apellidos = br.readLine();
                        cliente.setApellido(apellidos);
                        System.out.println("Ingrese el correo electrónico");
                        String email = br.readLine();
                        cliente.setEmail(email);
                        System.out.println("Ingrese la ciudad residencia");
                        String ciudadResidencia = br.readLine();
                        cliente.setCiudadResidencia(ciudadResidencia);
                        System.out.println("Ingrese la dirección de residencia");
                        String direccionResidencia = br.readLine();
                        cliente.setDireccionResidencia(direccionResidencia);
                        System.out.println("Ingrese el número de celular");
                        long celular = Long.parseLong(br.readLine());
                        cliente.setNoCelular(celular);
                        System.out.println("Ingrese el numero de cuenta bancaria");
                        long cuentaBancaria = Long.parseLong(br.readLine());
                        cliente.setNoCuentaBancaria(cuentaBancaria);
                        System.out.println("Ingrese la entidad Bancaria");
                        String entidadBancaria = br.readLine();
                        cliente.setEntidadBancaria(entidadBancaria);
                        System.out.println("Ingrese tipo de cuenta bancaria");
                        String tipoCuentaBancaria = br.readLine();
                        cliente.setTipoCuentaBancaria(tipoCuentaBancaria);
                        clientes.add(cliente);
                        System.out.println(cliente);
                        break;
                    case 3:
                        System.out.println("Listado de clientes");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println(i + " - " + clientes.get(i).getNombre() + " " + clientes.get(i).getApellido());
                        }
                        break;
                    case 4:
                        Contrato contrato = new Contrato();
                        System.out.println("Ingrese identificación del cliente para creación del contrato");
                        long consultaID = Long.parseLong(br.readLine());
                        Cliente contratoCliente = null;
                        for (Cliente x : clientes) {
                            if (x.getIdentificacion() == consultaID) {
                                contratoCliente = x;
                                break;
                            }
                        }
                        if (contratoCliente == null) {
                            System.out.println("Identificación no existe");
                            break;
                        }
                        contrato.setInmuebleContrato(inmueble);
                        contrato.setInmobiliariaContrato(inmobiliaria);
                        System.out.println("Ingrese número de contrato");
                        String numeroContrato = br.readLine();
                        contrato.setNumeroContrato(numeroContrato);
                        System.out.println("Ingrese la fecha del contrato");
                        String fechaContrato = br.readLine();
                        contrato.setFechaContrato(fechaContrato);
                        System.out.println("Ingrese la cantidad de meses del contrato");
                        double mesesContrato = Double.parseDouble(br.readLine());
                        contrato.setMesesContrato(mesesContrato);
                        System.out.println("Valor del contrato");
                        double valorContrato = contrato.getMesesContrato() * contrato.getInmuebleContrato().getValueRentPropertyCommission();
                        contrato.setValorContrato(valorContrato);
                        contratoCliente.addContract(contrato);
                        contrato.mostrarContrato(contratoCliente);
                        break;

                    case 5:
                        System.out.println("Ingrese identificación del cliente para creación del contrato");
                        long consultaIDLista = Long.parseLong(br.readLine());
                        Cliente contratoClienteLista = null;
                        for (Cliente x : clientes) {
                            if (x.getIdentificacion() == consultaIDLista) {
                                contratoClienteLista = x;
                                break;
                            }
                        }
                        if (contratoClienteLista == null) {
                            System.out.println("Identificación no existe");
                            break;
                        }

                        for (Contrato x : contratoClienteLista.getContratos()) {
                            System.out.println(x);
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese identificación del cliente para creación del contrato");
                        long consultaIDEliminar = Long.parseLong(br.readLine());
                        Cliente contratoClienteEliminar = null;
                        int i = 0;
                        for (Cliente x : clientes) {
                            if (x.getIdentificacion() == consultaIDEliminar) {
                                contratoClienteEliminar = x;
                                break;
                            }
                            i++;
                        }
                        if (contratoClienteEliminar == null) {
                            System.out.println("Identificación no existe");
                            break;
                        }

                        clientes.remove(i);

                        break;
                    case 7:
                        System.out.println("Gracias por usar la plataforma");
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingrese un valor válido");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Intente de nuevo\n");
                System.out.println(e);
            }
        }

    }

}
