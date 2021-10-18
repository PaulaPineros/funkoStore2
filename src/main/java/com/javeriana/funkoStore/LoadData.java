package com.javeriana.funkoStore;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javeriana.funkoStore.entities.Item;
import com.javeriana.funkoStore.entities.Producto;
import com.javeriana.funkoStore.entities.Usuario;
import com.javeriana.funkoStore.entities.Venta;
import com.javeriana.funkoStore.repositories.ProductoRepository;
import com.javeriana.funkoStore.repositories.VentaRepository;

@Configuration
public class LoadData {
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Bean
	CommandLineRunner initDB() {
		return args ->{
			Producto p1 = new Producto();
			p1.setNombre("Aang");	
			p1.setPrecio(80000);
			p1.setImagen("https://imgur.com/p27Dttz.png");
			p1.setDescripcion("Avatar: La leyenda de Aang");
			productoRepository.save(p1);
		
			Producto p2 = new Producto();
			p2.setNombre("Katara");	
			p2.setPrecio(70000);
			p2.setImagen("https://imgur.com/OmypY9J.png");
			p2.setDescripcion("Avatar: La leyenda de Aang");
			productoRepository.save(p2);
			
			Producto p3 = new Producto();
			p3.setNombre("Sokka");	
			p3.setPrecio(70000);
			p3.setImagen("https://imgur.com/EJjEBZW.png");
			p3.setDescripcion("Avatar: La leyenda de Aang");
			productoRepository.save(p3);
			
			Producto p4 = new Producto();
			p4.setNombre("Toph");	
			p4.setPrecio(75000);
			p4.setImagen("https://imgur.com/OgFBJuA.png");
			p4.setDescripcion("Avatar: La leyenda de Aang");
			productoRepository.save(p4);
			
			Producto p5 = new Producto();
			p5.setNombre("Zuko");	
			p5.setPrecio(85000);
			p5.setImagen("https://imgur.com/KaRj6tZ.png");
			p5.setDescripcion("Avatar: La leyenda de Aang");
			productoRepository.save(p5);
			
			Producto p6 = new Producto();
			p6.setNombre("Chucky");	
			p6.setPrecio(75000);
			p6.setImagen("https://imgur.com/SKARfAN.png");
			p6.setDescripcion("Chucky: El muñeco diabólico");
			productoRepository.save(p6);
			
			Producto p7 = new Producto();
			p7.setNombre("Jason Voorhees");	
			p7.setPrecio(70000);
			p7.setImagen("https://imgur.com/u0dyVJf.png");
			p7.setDescripcion("Viernes 13");
			productoRepository.save(p7);
			
			Producto p8 = new Producto();
			p8.setNombre("Pennywise");	
			p8.setPrecio(90000);
			p8.setImagen("https://imgur.com/87cU1V1.png");
			p8.setDescripcion("It");
			productoRepository.save(p8);
			
			Producto p9 = new Producto();
			p9.setNombre("Scooby Doo");	
			p9.setPrecio(80000);
			p9.setImagen("https://imgur.com/EL2d42G.png");
			p9.setDescripcion("Scooby Doo");
			productoRepository.save(p9);
			
			Producto p10 = new Producto();
			p10.setNombre("Shaggy");	
			p10.setPrecio(80000);
			p10.setImagen("https://imgur.com/SsGhKPp.png");
			p10.setDescripcion("Scooby Doo");
			productoRepository.save(p10);
			
			Producto p11 = new Producto();
			p11.setNombre("Iron man");	
			p11.setPrecio(95000);
			p11.setImagen("https://imgur.com/zoH5Geo.png");
			p11.setDescripcion("Marvel");
			productoRepository.save(p11);
			
			Producto p12 = new Producto();
			p12.setNombre("Dr. Strange");	
			p12.setPrecio(80000);
			p12.setImagen("https://imgur.com/ihFg5W5.png");
			p12.setDescripcion("Marvel");
			productoRepository.save(p12);
			
			Producto p13 = new Producto();
			p13.setNombre("Spiderman");	
			p13.setPrecio(75000);
			p13.setImagen("https://imgur.com/wKo96U5.png");
			p13.setDescripcion("Marvel");
			productoRepository.save(p13);
			
			Producto p14 = new Producto();
			p14.setNombre("Thor");	
			p14.setPrecio(75000);
			p14.setImagen("https://imgur.com/gttD5Jd.png");
			p14.setDescripcion("Marvel");
			productoRepository.save(p14);
			
			Producto p15 = new Producto();
			p15.setNombre("Thanos");	
			p15.setPrecio(80000);
			p15.setImagen("https://imgur.com/1Ju8Xh3.png");
			p15.setDescripcion("Marvel");
			productoRepository.save(p15);
			
			Usuario u1 = new Usuario();
			u1.setNombre("Mónica");
			u1.setApellido("Álvarez");
			u1.setEmail("ma@gmail.com");
			u1.setPassword("xxx");
			u1.setAdmin(false);
			
			Usuario u2 = new Usuario();
			u1.setNombre("Paula");
			u1.setApellido("Piñeros");
			u1.setEmail("pp@gmail.com");
			u1.setPassword("xxx");
			u1.setAdmin(false);
			
			Item i1 = new Item();
			i1.setPrecioUnitario(p14.getPrecio());
			i1.setCantidad(1);
			i1.setTotalProducto(p14.getPrecio());
			i1.setProducto(p14);
			
			Item i2 = new Item();
			i2.setPrecioUnitario(p1.getPrecio());
			i2.setCantidad(2);
			i2.setTotalProducto(p1.getPrecio()*2);
			i2.setProducto(p1);
			
			Item i3 = new Item();
			i3.setPrecioUnitario(p4.getPrecio());
			i3.setCantidad(1);
			i3.setTotalProducto(p4.getPrecio());
			i3.setProducto(p4);
			
			Venta v1 = new Venta();
			v1.setFecha((long) 20201004);
			v1.setUsuario(u1);
			v1.getItems().add(i1);
			v1.getItems().add(i2);
			v1.setTotalVenta(235000);
			ventaRepository.save(v1);
			
			Venta v2 = new Venta();
			v2.setFecha((long) 20211004);
			v2.setUsuario(u1);
			v2.getItems().add(i1);
			v2.setTotalVenta(75000);
			ventaRepository.save(v2);
			
			Venta v3 = new Venta();
			v3.setFecha((long) 20200120);
			v3.setUsuario(u2);
			v3.getItems().add(i1);
			v3.getItems().add(i2);
			v3.getItems().add(i3);
			v3.setTotalVenta(310000);
			ventaRepository.save(v3);
			
			Venta v4 = new Venta();
			v4.setFecha((long) 20190315);
			v4.setUsuario(u2);
			v4.getItems().add(i2);
			v4.setTotalVenta(160000);
			ventaRepository.save(v4);
		};
	}
}
