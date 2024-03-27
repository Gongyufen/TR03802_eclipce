package tr03802.zy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (urlPatterns = "/img")
public class Tppj extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
        String img1 = application.getRealPath("/imges/hhd.jpg");
        String img2 = application.getRealPath("/imges/my.jpg");
        BufferedImage image1 = ImageIO.read(new File(img1));
        BufferedImage image2 = ImageIO.read(new File(img2));
        String type = request.getParameter("type");
        BufferedImage buf = null;
        if ("hx".equals(type)) { // 横向拼接
            int width = image1.getWidth() + image2.getWidth();
            int height = Math.max(image1.getHeight(), image2.getHeight());
            buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = buf.getGraphics();
            g.drawImage(image1, 0, 0, null);
            g.drawImage(image2, image1.getWidth(), 0, null);
        } else if ("zx".equals(type)) { // 纵向拼接
            int width = Math.max(image1.getWidth(), image2.getWidth());
            int height = image1.getHeight() + image2.getHeight();
            buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = buf.getGraphics();
            g.drawImage(image1, (width - image1.getWidth()) / 2, 0, null);
            g.drawImage(image2, (width - image2.getWidth()) / 2, image1.getHeight(), null);
        }
        response.setContentType("image/png");
        ImageIO.write(buf, "png", response.getOutputStream());
    }
}
