/*
 * Copyright 2017 Glenn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Ratsit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RatsitSearch {

	public static void main(String[] args) {
	    new RatsitSearch(new RatsitURL("Glenn", "Stockholm"));
	}

	public RatsitSearch(RatsitURL url){
		try{
			Document document = Jsoup.connect(url.getURL()).get();
			Elements allResults = document.select(".search-list-item");

			for(Element result : allResults){
				String urlOfResult = result.select("div > a").attr("href");
				String baseURL = "https://www.ratsit.se";
				Ratsit ratsitObjOfResult = new Ratsit(baseURL + urlOfResult);


			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
